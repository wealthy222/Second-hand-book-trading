<template>
	<view>
		<u-modal :show="show" @confirm="evt" :content='content' showConfirmButton></u-modal>
		<view>
			<view class="notGoods" v-if="showCart == false">
				<image src="" mode="widthFix" style="width: 400rpx;"></image>
				<view class="notGoods-text">
					购物车暂无商品
				</view>
				<view class="notGoods-button" @click="placeOrder">
					去下单
				</view>
			</view>
			<view v-if="showCart == true">
				<view class="goods-detail" v-for="(item,index) in cartList" :key="item.id">
					<view class="detail-left">
						<view class="left">
							<checkbox-group @change="selected(item)">
								<checkbox class="xuanzhong" color="#E36452" :checked="checked" />
							</checkbox-group>
							<image :src="item.image" mode="widthFix" style="width: 150rpx;" @error="ErrSrc(index)">
							</image>
						</view>
						<view class="size">
							<text style="font-size: 25rpx;" class="bookName">书名：{{item.title}}</text>
							<view class="moddleView">
								<view class="price"><text
										class="goods-price">￥{{parseFloat(item.price*item.num).toFixed(2)}}/本</text>
								</view>
								<view class="numInfo">
									<text class="subtract" @click="reduce(item)">-</text>
									<text class="num">{{item.num}}</text>
									<text @click="add(item)" class="add">+</text>
								</view>
							</view>
						</view>
					</view>
					<view class="right">
						<image src="@/static/del.png" mode="widthFix" style="width: 35rpx;" @click="delht(item,index)">
						</image>
					</view>
				</view>
			</view>
			<view class="perch">
				
			</view>
			<view class="end">
				<view class="end-left">
					<checkbox-group @change="selectedall()">
						<checkbox class="" :checked="allchecked" />全选
					</checkbox-group>
					<view>总计:<text style="color: #f00;font-weight: bold;">￥ {{totalPrice}}</text></view>
				</view>
				<view class="end-right" @click="payment">
					结算({{totalNum}})
				</view>
			</view>
		</view>
		<spend-money :tolist2="tolist" @sendToList="getToList"></spend-money>
	</view>
</template>

<script>
	import spendMoney from "@/components/spendMoney/index.vue";
	import {
		mapState
	} from "vuex"
	export default {
		data() {
			return {
				show: false,
				content: '您尚未登录,点击确认跳转登录页面',
				username: "",
				userId: 0,
				//
				showCart: true,
				allchecked: false,
				checked: false,
				tolist: [],
				cartLenth: 0,
				address: "华中农业大学",
			}
		},
		onbeforeunload() {
			console.log("离开")
		},
		onShow() {
			if (!uni.getStorageSync("username")) {
				uni.showModal({
					content: "点击确认跳转",
					success: function(res) {
						if (res.confirm) {
							uni.navigateTo({
								url:"../login/login"
							})
						} 
					}
				})
			}
		},
		methods: {
			evt() {
				uni.navigateTo({
					url: "../login/login"
				})
			},
			onUnload() {
				console.log("离开了");
			},
			//、、、、、、、、
			getToList(item) {
				this.tolist = item;
				this.checked = true;
				this.allchecked = true;
			},
			payment() {
				this.cartList.map(item => {
					if (item.flag) {
						item.username = uni.getStorageSync("username");
						item.mobile = uni.getStorageSync("mobile")
						item.address = this.address;
						this.tolist.push(item)
					}
				})
				this.$store.dispatch('setMask', true);
			},
			ErrSrc(index) {
				this.cartList[index]['image'] = '../../static/nofound.jpg'
			},
			placeOrder() {
				uni.switchTab({
					url: "../sell/sell"
				})
			},
			delht(item, index) {
				// this.size.splice(index, 1)
				uni.showModal({
					content: '是否删除此商品',
					success: (res) => {
						if (res.confirm) {
							this.$JerryRequest({
								url: "/deleteUserCart?book_id=" + item.id,
								method: "DELETE",
								token: uni.getStorageSync("token")
							})
							this.$store.state.cartList.splice(index, 1);
							this.$Inter.JerryAlert("删除成功")
							if (this.$store.state.cartList == 0) {
								this.showCart = false
							}
						} else if (res.cancel) {}
					}
				})
			},
			change(e) {
				console.log(e)
			},
			selected(item) {
				item.flag = !item.flag
				if (!item.flag) {
					this.allchecked = false
				} else {
					const test = this.cartList.every(item => {
						return item.flag === true
					})
					if (test) {
						this.allchecked = true
					} else {
						this.allchecked = false
					}
				}
				// this.checked=!this.checked
				// this.totalNum()
			},
			selectedall() {
				this.allchecked = !this.allchecked
				if (this.allchecked) {
					this.cartList.map(item => {
						this.checked = true
						item.flag = true
					})
				} else {
					this.checked = false
					this.cartList.map(item => {
						item.flag = false

					})
				}
			},
			reduce(item) {
				let num = item.num
				// item.num = num-1
				// if(num <=0){
				//  return;
				// }
				if (num > 0) {
					num -= 1
				} else {
					num = 0
					return;
				}
				item.num = num
			},
			add(item) {
				let num = item.num
				if (num >= item.number) {
					this.$Inter.JerryAlert("超过最大售卖量")
				} else {
					item.num++;
				}
			}
		},
		onLoad() {
			let that = this;
			this.checked = false;
			this.allchecked = false;
			if (!uni.getStorageSync("username")) {
				this.show = true;
			} else {
				this.username = uni.getStorageSync("username");
				this.userId = uni.getStorageSync("id")
				this.$JerryRequest({
					url: "/getUserCart?user_id=" + that.userId,
					token: uni.getStorageSync("token")
				}).then(res => {
					that.$store.state.cartList = res.data;
					if (that.cartList.length > 0) {
						that.showCart = true;
					}
				}).catch()
			}
		},
		computed: {
			totalNum() {
				let totalNum = 0;
				this.cartList.map(item => {
					item.flag ? totalNum += item.num : totalNum += 0
				})
				return totalNum
			},
			totalPrice() {
				let totalPrice = 0;
				this.cartList.map(item => {
					item.flag ? totalPrice += parseInt(item.num * item.price) : totalPrice += 0
				})
				return totalPrice
			},
			...mapState({
				"cartList": "cartList"
			})
		},
		components: {
			spendMoney,
		}
	}
</script>

<style lang="scss" scoped>
	.perch {
		width: 100%;
		height: 60px;
	}
	.moddleView {
		display: flex;

		.price {}

		.numInfo {
			margin-left: 20px;

			text {
				width: 50rpx;
				line-height: 50rpx;
				text-align: center;
				display: inline-block;
				background-color: #F7F7F7;
				margin-right: 10rpx;
			}

			.add {
				color: #FA4305;
				border-radius: 10rpx 30rpx 30rpx 10rpx;
				margin-right: 20rpx;
			}

			.subtract {
				border-radius: 30rpx 10rpx 10rpx 30rpx;
			}
		}
	}






	.bookName {
		display: -webkit-box;
		-webkit-box-orient: vertical;
		-webkit-line-clamp: 2;
		overflow: hidden;
	}

	.goods {
		line-height: 80rpx;
		background-color: #fff;

		&-top {
			display: flex;
			justify-content: space-between;
			align-items: center;
			padding: 0 30rpx;
			border-bottom: 8rpx solid #F1F1F1;

			.name {
				color: #333;
				font-size: 31rpx;
				font-weight: bold;
			}
		}

		&-detail {
			display: flex;
			padding: 30rpx 15rpx 30rpx 30rpx;
			background-color: #fff;
			justify-content: space-between;
			border-bottom: 5rpx solid #F1F1F1;
			align-items: center;

			.detail-left {
				display: flex;

				.left {
					display: flex;
					align-items: center;
				}
			}

			.size {
				display: flex;
				justify-content: space-around;
				flex-direction: column;
				margin-left: 30rpx;

				.goods-price {
					font-size: 25rpx;
					color: #F44545;

				}
			}

			.right {}
		}

	}

	.notGoods {
		position: relative;
		top: 220rpx;
		text-align: center;
		display: flex;
		align-items: center;
		flex-direction: column;

		// line-height: 1334rpx;
		&-text {
			color: #808080;
			margin-bottom: 50rpx;
		}

		&-button {
			width: 260rpx;
			height: 70rpx;
			color: #F44545;
			border: 1rpx solid #F44545;
			text-align: center;
			line-height: 70rpx;
			border-radius: 48rpx;
		}
	}

	.end {
		width: 100%;
		height: 90rpx;
		background-color: #fff;
		position: fixed;
		bottom: 0;
		left: 0;
		display: flex;
		align-items: center;

		&-left {
			width: 70%;
			display: flex;
			justify-content: space-between;
			padding: 0 30rpx;

			.end-flex {
				display: flex;
				align-items: center;
			}
		}

		&-right {
			width: 30%;
			line-height: 90rpx;
			background-color: #F44545;
			text-align: center;
			color: #fff;
		}
	}
</style>
