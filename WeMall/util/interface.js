import {
	JerryRequest
} from './api.js';
import {
	JerrySecond
} from "./api.js"
export const api = {
	insertBookCollect(book_id, number) { 
		JerryRequest({
			url: '/insertBookCollect?book_id=' + book_id + "&number=" + number,
			method: "PUT",
			token:uni.getStorageSync("token")
		})
	},
	insertUserCart(user_id, book_id,seller_id) { 
		JerrySecond({
			url: "/insertUserCart",
			token:uni.getStorageSync("token"),
			data: {
				user_id,
				book_id,
				seller_id,
			}
		})
	},
	insertUserOrder(book_id, num, price, user_id,seller_id,username,mobile,address) { //插入用户订单的api
		JerrySecond({
			url: "/insertUserOrder",
			token:uni.getStorageSync("token"),
			data: {
				book_id,
				num,
				price,
				user_id,
				seller_id,
				username,
				mobile,
				address,
			}
		})
	},
	updateBooknumber(book_id,number){
		JerryRequest({
			url: '/updateBooknumber?book_id=' + book_id + "&number=" + number,
			method: "PUT",
			token:uni.getStorageSync("token")
		})
	},
	insertUserOrderList(user_id, list) {
		JerrySecond({
			url: "/insertUserOrderList",
			token:uni.getStorageSync("token"),
			contentType:'application/json',
			data: {
				list:list,
				user_id,
			}
		})
	},
	deleteOrderComplete(id){
		JerryRequest({
			url:"/deleteOrderComplete?id="+id,
			method:"DELETE",
			token:uni.getStorageSync("token")
		})
	},
	insertBookByUser(image,title,author,price,cate_id,user_id,collect, num,number,flag){
		JerrySecond({
			url:"/insertBookByUser",
			token:uni.getStorageSync("token"),
			data:{
				image,
				title,
				author,
				price,
				cate_id,
				user_id,
				collect,
				num,
				number,
				flag
			}
		})
	},
	//fans操作
	insertAttent(user_id,seller_id){
		JerrySecond({
			url:"/insertAttent",
			token:uni.getStorageSync("token"),
			data:{
				user_id,
				seller_id,
			}
		})
	},
	updateAttent(seller_id,number){
		JerryRequest({
			method:"PUT",
			url:"/updateUserByFans?number="+number+"&seller_id="+seller_id,
			token:uni.getStorageSync("token"),
		})
	},
	deleteAttent(user_id,seller_id){
		JerryRequest({
			url:"/deleteAttentById?user_id="+user_id+"&seller_id="+seller_id,
			token:uni.getStorageSync("token"),
			method:"DELETE"
		})
	},
	
}
