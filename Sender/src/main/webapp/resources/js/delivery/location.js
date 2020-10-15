$(()=>{
    let regDepartTable = $('.location.depart');
    let departPop = regDepartTable.find('.depart-popup-btn');

    let popBtn = $('.add-popup-btn');
    let departBtn = $('.depart-btn');
    let arrivalBtn = $('.arrival-btn');


    popBtn.each((i)=>{
    	popBtn.eq(0).click((e)=>{
    		
            window.open("/location/locationPopup", "출발 장소 선택", "width=800, height=300, left=600, top=100");
        });
    	popBtn.eq(1).click((e)=>{
    		
            window.open("/location/locationArrivalPopup", "도착 장소 선택", "width=800, height=300, left=600, top=100");
        });
    })
        
    departBtn.each((i)=>{
        departBtn.eq(i).click((e)=>{
            
            $(opener.document).find('.depart-zip').val($('.location-post').eq(i).text());
            $(opener.document).find('.depart-add').val($('.location-address').eq(i).text());
            $(opener.document).find('.depart-add-dtl').val($('.location-address-dtl').eq(i).text());
            $(opener.document).find('.depart-phone').val($('.location-phone').eq(i).text());    
            
            $(opener.document).find('.depart-add-dtl').focus();

            window.close();
        });         
    })
    
    arrivalBtn.each((i)=>{
        arrivalBtn.eq(i).click((e)=>{
            
            $(opener.document).find('.arrival-zip').val($('.location-post').eq(i).text());
            $(opener.document).find('.arrival-add').val($('.location-address').eq(i).text());
            $(opener.document).find('.arrival-add-dtl').val($('.location-address-dtl').eq(i).text());
            $(opener.document).find('.arrival-phone').val($('.location-phone').eq(i).text());
            
            $(opener.document).find('.arrival-add-dtl').focus();

            window.close();
        });         
    })

    

    
    
})