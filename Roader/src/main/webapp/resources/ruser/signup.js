	var all_cheack="N";
    var ruserAgreEssen = "N";
    var ruserAgreOption = "N";
	
$(()=>{
    var main = $(".main");
    var emailOne = $(".main").find("input[name='emailOne']");
    var emailTwo = $(".main").find("select[name='emailTwo']");
	var ruserEmail=emailOne.val()+emailTwo.val();
    var signupBtn = main.find(".signup-button");

    var ruserId = main.find("input[name='ruserId']");
    var ruserPw = main.find("input[name='ruserPw']");
    var SUSER_PWChk = main.find("input[name='pwd-check'");

    var ruserName = main.find("input[name='ruserName'");
    var ruserPostode = main.find(".zip");
    var addressOne = $(".main").find("input[name='addressOne']");
    var addressTwo = $(".main").find("input[name='addressTwo']");
    var rphone = $(".main").find("input[name='rphone']");
    var numInput = main.find(".num-input");
    var requireInput = main.find(".required");
   
    var idErr = main.find(".id-err");
    var idDupleErr = main.find(".id-duple-err");
    var idConfirm = main.find(".id-confirm");
   
    var pwdErr = main.find(".pwd-err");
    var pwdChkErr = main.find(".pwd-check-err");
    
    var emailErr = main.find(".email-err");
    var emailDupleErr = main.find(".email-duple-err");

    var regId = RegExp(/^[a-zA-Z0-9]{4,12}$/);
    var regPwd = RegExp(/^[a-zA-Z0-9]{4,12}$/);
    var regEmail = RegExp(/([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/);
    var regNum = RegExp(/^[0-9]*$/);
    var regPhone = RegExp(/^01(?:0|1|[6-9])(?:\d{3}|\d{4})\d{4}$/);
    var idCheck = false;
    var pwdCheck = false;
    var emailCheck = false;
    

    
    	
	ruserId.keyup(()=>{

		fetch('idCheck',{
            method: "POST",
            headers: {
            	"Content-Type": "application/json"
            },
            body: JSON.stringify({
                ruserId: ruserId.val()
            })
        })
        .then(res=>res.json())
        .then(json=>{
            
            if(!regId.test(ruserId.val())){
            	idErr.removeClass("d-none");
                idConfirm.addClass("d-none");
                idDupleErr.addClass("d-none");
            	idCheck=false;
                return;
            } else {
            	idErr.addClass("d-none");
                
                if(json == 1) {
                	idDupleErr.removeClass("d-none");
                	idConfirm.addClass("d-none");
                    
                	idCheck=false;

                    return;
                }
                else {
                	idDupleErr.addClass("d-none");
                    idConfirm.removeClass("d-none");
                    
                    idCheck = true;
                }
            }
            
        })

    })
    
    ruserPw.keyup(()=>{
    	if(!regPwd.test(ruserPw.val())){
            pwdErr.removeClass("d-none");            
            pwdCheck = false;
            return;
        } else {
            pwdErr.addClass("d-none");
            pwdCheck = true;
        }
    })
    
    SUSER_PWChk.keyup(()=>{

        if(ruserPw.val()!=SUSER_PWChk.val()) {
            pwdChkErr.removeClass("d-none");
            pwdCheck = false;
            return;
        } else {
            pwdChkErr.addClass("d-none");
            pwdCheck = true;
        }

    })

     
    numInput.on("keyup", function() {
	    $(this).val($(this).val().replace(/[^0-9]/g,""));
    });


    
    // focusout(function() {
	// 		if(rphone.val() === ""){
				
	// 			$(".rphone").val("");
	// 		    pwdCheck = false;
	// 			return false;
	// 		}
	// 		else if (!regExp.test($(".rphone").val())) {
	// 			alert("잘못된 휴대폰 번호입니다. 숫자, - 를 뺀 숫자만 입력하세요.");
	// 			return $(".rphone").val("");
	// 		    pwdCheck = false;
	// 		}
	// 		else
	// 		    pwdCheck = true;
	// 		return ;
	// 	});
	// 	$(".ruserName").focusout(function() {
	// 		if ($(".ruserName").val() === "") {
	// 			alert("이름을 입력해주세요.");
	// 			pwdCheck = false;
	// 			return $(".ruserName").val("");
	// 		}
	// 	});
     signupBtn.click((e)=>{
    	
    	console.log(emailOne.val());
    	console.log(ruserEmail);
		console.log("idCheck::::"+idCheck);
		console.log("addressOne::::"+addressOne);
		console.log("addressTwo::::"+addressTwo);
		console.log("address::::"+addressOne.val() + addressOne.val());
		console.log("pwdCheck:::"+pwdCheck);

		console.log(rphone.val());
		console.log("requireInput::::"+requireInput.val());
       
        if(!regId.test(ruserId.val())){
            pwdCheck = false;
             alert("잘못된 아이디입니다.");
             e.preventDefault();
            return;
        }
        else if(emailOne.val()=="") {
            pwdCheck = false;
            alert("이메일아이디 입력하세요");
            emailOne.val() ="";
             e.preventDefault();
            return;
        }
        else if(rphone.val()=="") {
            pwdCheck = false;
            alert("전화번호를 입력하세요");
            rphone.val() ="";
             e.preventDefault();
            return;
        } else if(!regPhone.test(rphone.val())) {
            pwdCheck = false;
            alert("잘못된 휴대폰 번호입니다. 숫자, - 를 뺀 숫자만 입력하세요.");
            rphone.val() ="";
             e.preventDefault();
            return;
        }
        else if(ruserName.val()=="") {
            pwdCheck = false;
            alert("회원이름을 입력하세요");
            ruserName.val() ="";
            ruserName.focus();
             e.preventDefault();
            return;
        }
        else if(addressOne.val()=="") {
            pwdCheck = false;
            alert("주소찾기를 눌러주세요.");
             e.preventDefault();
            return;
        }
        else if(ruserAgreEssen=="N"){
           alert("필수항목을 동의해주세요");
           pwdCheck = false;
           e.preventDefault();
           return;
        }
        else{


		       
        fetch('signup',{
            method: "POST",
            headers: {
            	"Content-Type": "application/json; charset=utf-8"
            },
            body: JSON.stringify({
                ruserId: ruserId.val(),
                ruserPw: ruserPw.val(),
                ruserName: ruserName.val(),
                ruserEmail: emailOne.val()+emailTwo.val(),
                ruserAddress1: addressOne.val(),
                ruserAddress2:  addressTwo.val(),
                ruserPostCode: $("input[name='ruserPostCode']").val(),
                rPhone: rphone.val(),
 				ruserAgreEssen : ruserAgreEssen,
            	ruserAgreOption : ruserAgreEssen
            })
        })
        .then(()=>{
        	alert("회원가입이 완료되었습니다!")
        	window.location.href = "/";
        });
    }
    })
    
    
    
    
   
});