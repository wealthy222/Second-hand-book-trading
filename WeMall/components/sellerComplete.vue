<template>
	<view class="top">
		<view class="card" v-for="(item,index) in list":key="item.id" >
						<view class="image" >
							<image :src="item.image" @error="Error(index)"></image>
						</view>
						<view class="info">
							<p class="title">书名：{{item.title}}</p>
							<p class="author">作者：{{item.author}}</p>
							<p class="price">¥{{item.price}}</p>
						</view>
					</view>
	</view>
</template>

<script>
	export default {
		name: "top",
		data() {
			return {};
			
		},
		props: {
			list: {
				type: Array || Object,
				required: true,
				default: []
			},
		},
		methods: {
			Error(index) {
				this.list[index]['image'] = '../../static/nofound.jpg'
			},
		},
	}
</script>

<style lang="scss">
	.slot {
		height: 70rpx;
		display: flex;
		justify-content: center;
		align-items: center;
		width: 100%;
		color: #000000;
	}

	.top {
		
		background-color: #EEEEEE;
	}

	.card {
		display: flex;
		background-color: #FFFFFF;
		height: 230rpx;
		margin-bottom: 10px;
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
			margin-top: 6px;
			color: #ff0000;
		}
	}

	.u-page {
		padding: 0;
	}

	.u-demo-block__title {
		padding: 10px 0 2px 15px;
	}

	.swipe-action {
		&__content {
			padding: 25rpx 0;

			&__text {
				font-size: 15px;
				color: $u-main-color;
				padding-left: 30rpx;
			}
		}
	}
</style>
