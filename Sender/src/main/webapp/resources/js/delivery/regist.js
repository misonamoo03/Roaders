$(()=>{

	let main = $('.main');
	/*layer popup*/
    let btn = main.find('.popup-btn');
    let pop = main.find('.popup');
    let closeBtn = main.find('.close');
    let x = 0;
    let y = 0;
    
    /*add-file*/
    let addBtn = main.find('.add-btn');
    let delBtn = main.find('.del-btn');
    let imageSpan = main.find('.image-container');
    let imageFile = main.find('.image-container input[type="file"]');    
    let maxCount = 1;

    /* add-price */
    let priceBtn = main.find('.add-price');
    let priceInput = main.find('input[name="DEL_CONTENT_PRICE"]');
    let itemSectionSelect = main.find('.item-section-select');
    let itemWidth = main.find('.item-width');
    let itemLength = main.find('.item-length');
    let itemHeight = main.find('.item-height');
    let itemWeightSelect = main.find('.item-weight-select');

    let price = main.find('.price');
    let extraPrice = main.find('.extra-price');

    let itemSection = main.find('.item-section');
    let itemSectionExtra = main.find('.item-section-extra');
    let itemSize = main.find('.item-size');
    let itemSizeExtra = main.find('.item-size-extra');
    let itemWeight = main.find('.item-weight');
    let itemWeightExtra = main.find('.item-weight-extra');
    let itemDistance = main.find('.item-distance');
    let itemDistanceExtra = main.find('.item-distance-extra');

    let extraTotal = main.find('.extra-total');
    let totalPrice = main.find('.total-price');

    let popTable = $('.item-popup-table');
    let popItemName = popTable.find('.pop-item-name');
    let popItemCatagory = popTable.find('.pop-item-catagory');

    let sendDateBtn = popTable.find('.send-data-btn');

    let departX = main.find('.depart-x');
    let departY = main.find('.depart-y');
    let arrivalX = main.find('.arrival-x');
    let arrivalY = main.find('.arrival-y');

    /* fee-box */
    let feeSection = $('.delivery-fee-box');
    let requireInput = $('.require');

    let sendDataBtn = $('.reg-delivery-btn');
    let sendEditBtn = $('.del-edit-btn');

    /* add-price */
    priceBtn.click((e)=>{

    	if(requireInput.eq(i).val()=='') {
            //e.preventDefault();
            alert('배송비 계산을 위한 항목을 정확히 입력해주세요.');
            
            return;
        }

        feeSection.removeClass('d-none');

        price.text(priceInput.val());
        extraPrice.text(parseInt(3500 + price.text() * 0.05));

        itemSection.text(itemSectionSelect.val());

        if(itemSectionSelect.val()==='공산품') {
            itemSectionExtra.text(0);
        } else if(itemSectionSelect.val()==='신선식품') {
            itemSectionExtra.text(10);
        } else if(itemSectionSelect.val()==='냉동식품') {
            itemSectionExtra.text(20);
        } else if(itemSectionSelect.val()==='화훼상품') {
            itemSectionExtra.text(30);
        }
        
        let itemSizeSum = parseInt(itemWidth.val()) 
        + parseInt(itemLength.val()) + parseInt(itemHeight.val());
        
        itemSize.text(itemSizeSum);
        
        if(itemSizeSum <= 60) {
            itemSizeExtra.text(0);
        } else if(itemSizeSum <= 80) {
            itemSizeExtra.text(5);
        } else if(itemSizeSum <= 100) {
            itemSizeExtra.text(10);
        } else if(itemSizeSum <= 150) {
            itemSizeExtra.text(15);
        } else if(itemSizeSum <= 200) {
            itemSizeExtra.text(20);
        } else if(itemSizeSum > 200) {
            itemSizeExtra.text(30);
        }

        itemWeight.text(itemWeightSelect.val());

        if(itemWeightSelect.val()==='1') {
            itemWeightExtra.text(0);
        } else if(itemWeightSelect.val()==='2') {
            itemWeightExtra.text(5);
        } else if(itemWeightSelect.val()==='3') {
            itemWeightExtra.text(10);
        } else if(itemWeightSelect.val()==='4') {
            itemWeightExtra.text(15);
            itemWeightExtra.text(20);
        } else if(itemWeightSelect.val()==='6') {
            itemWeightExtra.text(30);
        } else if(itemWeightSelect.val()==='7') {
            itemWeightExtra.text(40);
        }
        
        
        /*거리 구하는 함수 실행 밑 -> 결과 값 가격 계산 폼 - 거리에 넣고 할증율 계산*/
        let distance = calcCrow(departX.val(), departY.val(), arrivalX.val(), arrivalY.val()).toFixed(0);
        itemDistance.text(distance);
        console.log(departX.val());
        console.log(departY.val());
        console.log(arrivalX.val());
        console.log(arrivalY.val());
        console.log(distance);

        if(itemDistance.text() <= 1) {
            itemDistanceExtra.text(0);
        } else if(itemDistance.text() <= 2) {
            itemDistanceExtra.text(5);
        } else if(itemDistance.text() <= 3) {
            itemDistanceExtra.text(10);
        } else if(itemDistance.text() <= 5) {
            itemDistanceExtra.text(15);
        } else if(itemDistance.text() <= 7) {
            itemDistanceExtra.text(20);
        } else if(itemDistance.text() <= 10) {
            itemDistanceExtra.text(30);
        } else if(itemDistance.text() > 10) {
            itemDistanceExtra.text(40);
        }
        
        let extraSum
        = parseInt(itemSectionExtra.text()) 
        + parseInt(itemSizeExtra.text()) 
        + parseInt(itemWeightExtra.text())
        + parseInt(itemDistanceExtra.text());

        extraTotal.text(extraSum);

        let totalSum =  parseInt(extraPrice.text()) + parseInt(extraPrice.text()) * (extraSum/100);

        totalPrice.val(totalSum);

        sendDataBtn.removeClass('d-none');
        sendEditBtn.removeClass('d-none');

    })

    /* 좌표 두개로 직선거리 구하는 함수 */
    function calcCrow(lat1, lon1, lat2, lon2) {
        var R = 6371; // km
        var dLat = toRad(lat2-lat1);
        var dLon = toRad(lon2-lon1);
        var lat1 = toRad(lat1);
        var lat2 = toRad(lat2);

        var a = Math.sin(dLat/2) * Math.sin(dLat/2) +
            Math.sin(dLon/2) * Math.sin(dLon/2) * Math.cos(lat1) * Math.cos(lat2); 
        var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
        var d = R * c;
        return d;
    }

    // Converts numeric degrees to radians
    function toRad(Value) {
        return Value * Math.PI / 180;
    }

    /*add-file-input
    addBtn.click(()=>{

        if(maxCount>=3) {
        	alert('이미지는 3개까지만 추가 가능합니다!');
        	return;
        }

        let template = `
            <li><input type="file"></li>
        `;
        imageSpan.append(template);

        maxCount++;
    })
    
    remove-file
    delBtn.click(()=>{
        $('.image-container li:not(:first):last-child').remove();
    	maxCount--;
    	
    	if(maxCount < 0) return;
    })
    */
    
    /*layer popup*/
    btn.each((i)=>{
        btn.eq(i).click((e)=>{
            x = e.clientX / 2;
            y = e.clientY / 5;

            pop.eq(i).show();
            pop.draggable();
            pop.eq(i).css('left', x + 'px');
            pop.eq(i).css('top', y + 'px');
        });
        
    })

    closeBtn.each((i)=>{
        closeBtn.eq(i).click(()=>{
            pop.eq(i).hide();
        })
    })
    
})