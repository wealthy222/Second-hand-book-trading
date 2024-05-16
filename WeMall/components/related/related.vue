<template>
	<view class="head">
		<text>相关功能</text>
		<view class="mydiv">
			<view class="bottom_div" @click="handle0">
				<image src="https://gitee.com/jerry-mall/static/raw/master/icon/03.png" class="image_01"></image>
				<view><text>我的发布</text></view>
			</view>
			<view class="bottom_div" @click="handle1">
				<image src="https://gitee.com/jerry-mall/static/raw/master/icon/01.png"></image>
				<view><text>需求中心</text></view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				user_id: 0
			}
		},
		methods: {
			handle0: function() {
				uni.navigateTo({
					url: "../../pages/myfabu/myfabu"

				})
			},
			handle1: function() {
				uni.navigateTo({
					url:"../../pages/center/center"
				})

			},
			// async getInformation() {
			// 	const res = await this.$JerryRequest({
			// 		url: ""
			// 	})
			// }
		},
		onLoad() {
			
		}
	}
</script>

<style lang="scss">
	.head {
		background-color: white;
		border-radius: 7px;
		height: 240rpx;
		width: 92%;
		margin: 0 auto;
		position: relative;
		top: -100rpx;
		text {
			font-size: 14px;

		}
	}

	.mydiv {
		display: flex;
		justify-content: space-between;
		flex: 1;
	}
	.bottom_div {
		margin-top: 30rpx;
		text-align: center;

		image {
			width: 80rpx;
			height: 80rpx;
			border-radius: 90rpx;
			border: 1px;
			background-color: lightblue;
		}
		.image_01{
			width: 86rpx;
		}
		view {
			margin-top: 14rpx;
			text-align: center;
			text {
				font-size: 24rpx !important;
				text-align: center;
			}
		}
	}

	.bottom_div {
		view {
			text {
				font-size: 28rpx;
			}
		}
	}
</style>
