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
			</view>
		</view>
	
	</view>
</template>

<script>
	import popup from "@/components/bookOrderPopup.vue"
	export default {
		data() {
			return {
			}
		},
		props: {
			list: {
				type: Array || Object,
				required: true,
				default: [],
			}
		},
		methods: {
			Error(index) {
				this.list[index]['image'] = '../../static/nofound.jpg'
			}
		},
		components:{
			popup,
		}
	}
</script>

<style lang="scss">
	.operate {
		width: 45%;
		height: 46rpx;
		text-align: right;
		position: absolute;
		bottom: 0;
		right: 0px;
		display: flex;
		.uButton {
			width: 50%;
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
