$(()=>{
    let itemTr = $('.itme-tr');
    let itemDataBtn = itemTr.find('.item-data-btn');

    //팝업에 있는 내용을 배송등록에 등록시켜주는 부분   
    itemTr.each((i)=>{
        itemDataBtn.eq(i).click((e)=>{
            //부모창 : $(opener.document).find('.item-name')
            //반복되는 itemTr 각각의 자식 중 해당 태그에 있는 text를 가져오는 것
            $(opener.document).find('.item-name').val(itemTr.eq(i).children('.pop-item-name').text());
            $(opener.document).find('.item-price').val(itemTr.eq(i).children('.pop-item-price').text());
            
            //기존 img 태그가 있기 때문에 그 부분을 삭제한 후에 넣어줘야해서 remove 코드 사
            $(opener.document).find('.select_img *').remove();
            $(opener.document).find('.select_img').append(itemTr.eq(i).children('.pop-item-img').html());

            $(opener.document).find('.item-width')
            .val(itemTr.eq(i).children('.pop-size').children('.pop-item-width').text());
            $(opener.document).find('.item-length')
            .val(itemTr.eq(i).children('.pop-size').children('.pop-item-length').text());
            $(opener.document).find('.item-height')
            .val(itemTr.eq(i).children('.pop-size').children('.pop-item-height').text());

            $(opener.document).find('.item-weight-select')
            .val(itemTr.eq(i).children('.pop-item-weight').children('.pop-item-weight-input').val());

            $(opener.document).find('.item-catagory')
            .val(itemTr.eq(i).children('.pop-item-category').children('.pop-item-category-input').val());

            //상품구분이 아이템은 val값이 숫자로 되어있고 배송은 텍스트로 되어있기 때문에 item val값에 따라 배송에 넣어
            let itemType = itemTr.eq(i).children('.pop-item-type').children('.pop-item-type-input').val();

            if(itemType==1) {
                $(opener.document).find('.item-section-select').val('공산품');
            } else if(itemType==2) {
                $(opener.document).find('.item-section-select').val('신선식품');
            } else if(itemType==3) {
                $(opener.document).find('.item-section-select').val('냉장식품');
            } else if(itemType==4) {
                $(opener.document).find('.item-section-select').val('화훼상품');
            }
        });         
    })
})