
const popup = document.querySelector(".Popup");
const param = new URLSearchParams(location.search);
const link  = location.pathname.slice(9)

popup.addEventListener('click', (element)=>{
	
    let elementClicked  = element.target.classList[0];
    let elementsToClose = ["Popup_Close", "Popup_Wrapper", "Buttons_Cancel"];
    let close = elementsToClose.some(elementsToClose => elementsToClose === elementClicked);
	
    if (close) {
		location.href = link+"?User="+param.get("User")+"&Account="+param.get("Account")+"&Action=Show";
    }

})

function CallMovimentacaoTRN(type){
	location.href = link+"?User="+param.get("User")+"&Account="+param.get("Account")+"&Action=TRNOpen&Method="+type;
}
