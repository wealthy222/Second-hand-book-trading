<template>
	<view class="top">
		<u-subsection mode="subsection" activeColor="#3c9cff" :list="list" :current="curNow" @change="sectionChange">
		</u-subsection>
		<book-order :list="BookData" v-if="show"></book-order>
		<book-complete v-if="!show" :list="BookDataComplete"></book-complete>
	</view>

</template>

<script>
	import bookOrder from "@/components/bookOrderComponents.vue"
	import bookComplete from "@/components/bookOrderComplete.vue"
	import {
		mapState
	} from 'vuex';
	export default {
		data() {
			return {
				BookData: [],
				BookDataComplete:[],
				list: ['待发货', '已收货'],
				curNow: 0,
				show:true,
			}
		},
		methods: {
			async dataGet(user_id) {
				const res = await this.$JerryRequest({
					url: "/getUserOrder?user_id=" + user_id,
					method: "GET",
					token:uni.getStorageSync("token")
				})
				this.BookData = res.data;
			},
			sectionChange(index) {
				let that = this;
				this.curNow = index;
				if(this.curNow == 1){
					this.show = false;
					this.$JerryRequest({
						url:"/getUserOrderComplete?user_id="+uni.getStorageSync("id"),
						token:uni.getStorageSync("token")
					}).then(res => {
						that.BookDataComplete = res.data;
					})
				}else{
					this.show = true;
				}
			}
		},
		computed: {
			...mapState(['usernameId'])
		},
		created() {

		},
		components: {
			bookOrder,
			bookComplete
		},
		onShow() {
			this.dataGet(uni.getStorageSync("id"));
		}
	}
</script>

<style lang="scss">
	.top {
		width: 100%;
		height: 100%;
		background-color: #EEEEEE;
	}
	page {
		background-color: #EEEEEE;
	}
</style>
