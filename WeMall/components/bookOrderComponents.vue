<template>
	<view class="top">
		<view class="card" v-for="(item,index) in list" :key="item.id">
			<view class="image">
				<image :src="item.image" @error="Error(index)"></image>
			</view>
			<view class="info">
				<p class="title">书名：{{item.title}}</p>
				<p class="author">作者：{{item.author}}</p>
				<view class="bookPrice">
					<view class="price">
						<p>¥{{(item.price).toFixed(2)}}</p>
					</view>
					<view class="num">
						<p>数量：×{{item.num}}</p>
					</view>
				</view>
				<view class="operate" @click="submit(item.orderId,index)">
					<u-button class="uButton" type="primary" text="确定收货" size="mini"></u-button>
				</view>
			</view>
		</view>
		<u-modal :show="show" showCancelButton :title="title" @confirm="comfirm" @cancel="cancel">
			<view class="slot-content">
				<rich-text :nodes="content"></rich-text>
			</view>
		</u-modal>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				show: false,
				title: '订单确认',
				content: "是否确认收货",
				bookindex:0//需要删除的书数组索引
			}
		},
		props: {
			list: {
				type: Array || Object,
				required: true,
				default: [],
				orderId:0,//选中收货的orderId
				sellerId:0			}
		},
		methods: {
			cancel(){
				this.show = false;
			},
			comfirm(){
				this.show = false;
				let that = this;
				let book_id = this.list[this.bookindex].id;
				let num = this.list[this.bookindex].num;
				let price = this.list[this.bookindex].price;
				that.sellerId = that.list[this.bookindex].sellerId;
				let user_id = uni.getStorageSync("id");
				this.$JerrySecond({
					url:"/insertUserOrderComplete",
					data:{
						book_id:book_id,
						num:num,
						price:price,
						user_id:user_id,
						seller_id:that.sellerId,
					},
					token:uni.getStorageSync("token"),
				}).then(res => {
					this.$Inter.JerryAlert('收货成功');
					that.$JerryRequest({
						url:"/deleteUserOrder?id="+that.orderId,
						method:"DELETE",
						token:uni.getStorageSync("token")
					})
					that.list.splice(this.bookindex,1)
				})
			},
			submit(id,index) {
				this.bookindex = index;
				this.orderId = id;
				this.show = true;
				
			},
			Error(index) {
				this.list[index]['image'] = '../../static/nofound.jpg'
			}
		},
	}
</script>

<style lang="scss">
	.operate {
		width: 20%;
		height: 46rpx;
		text-align: right;
		position: absolute;
		bottom: 0;
		right: 0px;
		.uButton {
			width: 100%;
		}
	}

	.bookPrice {
		width: 100%;
		height: 66rpx;
		display: flex;
	}

	.num {
		color: #b4b4b4;
		font-size: 13px;
		margin-top: 4px;
		margin-left: 50%;
	}

	.top {
		background-color: #EEEEEE;
	}

	.card {
		display: flex;
		background-color: #FFFFFF;
		height: 230rpx;
		margin-bottom: 10px;
		position: relative;
	}

	.image {
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;

		image {
			height: 200rpx;
			width: 200rpx;
		}

		flex: 1;
	}

	.info {
		flex: 2;

		.title {
			display: -webkit-box;
			-webkit-box-orient: vertical;
			-webkit-line-clamp: 2;
			overflow: hidden;
			margin-top: 3px;
			font-size: 14px;
			font-weight: 800;
		}

		.author {
			display: -webkit-box;
			-webkit-box-orient: vertical;
			-webkit-line-clamp: 1;
			overflow: hidden;
			margin-top: 4px;
		}

		.price {
			margin-top: 4px;
			color: #ff0000;
		}
	}
</style>
