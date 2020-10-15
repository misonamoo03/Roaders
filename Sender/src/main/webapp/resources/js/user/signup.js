	var all_cheack="N";
    var SUSER_AGRE_ESSEN = "N";
    var SUSER_AGRE_OPTION = "N";
	
$(()=>{
    var main = $(".main");
    var emailOne = $(".main").find("input[name='emailOne']");
    var emailTwo = $(".main").find("select[name='emailTwo']");
	var SUSER_EMAIL=emailOne.val()+emailTwo.val();
    var signupBtn = main.find(".signup-button");

    var SUSER_ID = main.find("input[name='SUSER_ID']");
    var SUSER_PW = main.find("input[name='SUSER_PW']");
    var SUSER_PWChk = main.find("input[name='pwd-check'");

    var SUSER_NAME = main.find("input[name='SUSER_NAME'");
    var SUSER_POSTCODE = main.find(".zip");
    var addressOne = $(".main").find("input[name='addressOne']");
    var addressTwo = $(".main").find("input[name='addressTwo']");
    var SPHONE = main.find("input[name='sphone']");
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
        
    var idCheck = false;
    var pwdCheck = false;
    var emailCheck = false;
    

    
    	
	SUSER_ID.keyup(()=>{

		fetch('idCheck',{
            method: "POST",
            headers: {
            	"Content-Type": "application/json"
            },
            body: JSON.stringify({
                SUSER_ID: SUSER_ID.val()
            })
        })
        .then(res=>res.json())
        .then(json=>{
        	
            if(!regId.test(SUSER_ID.val())){
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
    
    SUSER_PW.keyup(()=>{
    	if(!regPwd.test(SUSER_PW.val())){
            pwdErr.removeClass("d-none");            
            pwdCheck = false;
            return;
        } else {
            pwdErr.addClass("d-none");
            pwdCheck = true;
        }
    })
    
    SUSER_PWChk.keyup(()=>{

        if(SUSER_PW.val()!=SUSER_PWChk.val()) {
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
    
     signupBtn.click((e)=>{
    
    	console.log(emailOne.val());
    	console.log(SUSER_EMAIL);
		console.log("idCheck::::"+idCheck);
		
		console.log("addressOne::::"+addressOne);
		console.log("addressTwo::::"+addressTwo);
		console.log("address::::"+addressOne.val() + addressOne.val());
		console.log("pwdCheck:::"+pwdCheck);

		console.log(SPHONE.val());
		console.log("requireInput::::"+requireInput.val());
        if((!(idCheck&&pwdCheck)) || requireInput.val()=="") {
           alert("회원가입 항목을 정확히 입력해주세요!");
           e.preventDefault();
           
           return;
        }
        
        fetch('signup',{
            method: "POST",
            headers: {
            	"Content-Type": "application/json; charset=utf-8"
            },
            body: JSON.stringify({
                SUSER_ID: SUSER_ID.val(),
                SUSER_PW: SUSER_PW.val(),
                SUSER_NAME: SUSER_NAME.val(),
                SUSER_EMAIL: emailOne.val()+emailTwo.val(),
                SUSER_ADDRESS: addressOne.val() + addressTwo.val(),
                SUSER_POSTCODE: $("input[name='SUSER_POSTCODE']").val(),
                SPHONE: SPHONE.val(),
 				SUSER_AGRE_ESSEN : SUSER_AGRE_ESSEN,
            	SUSER_AGRE_OPTION : SUSER_AGRE_OPTION
            })
        })
        .then(()=>{
        	alert("회원가입이 완료되었습니다!")
        	window.location.href = "/";
        });
    })
    
    
    
    
   
});