<template>
<div>
송장번호 조회<br>
<form v-on:submit.prevent="onSubmitForm">
<input v-model="form.deliveryNumber" type="text" id="deliveryNumber" placeholder="송장번호"><br>
<button type="submit">배송조회</button>
</form>
</div>
</template>

<script>
import axios from 'axios'

export default {
	data(){
		return{
			form:{
				deliveryNumber:''
			}

		}
	},
	methods: {
		onSubmitForm(){
			let deliveryNumber = this.form.deliveryNumber;
			
			console.log(deliveryNumber)
			
			axios.post('/Delivery/Detail?deliveryNumber='+deliveryNumber,this.form)
				 .then((res)=>{
					
				 })
		}


	}
}
</script>

<style>

</style>