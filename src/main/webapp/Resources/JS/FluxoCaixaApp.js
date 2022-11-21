

const Btn_Deteils      = document.querySelector("#FC_Btn_Details")
const MainBox          = document.querySelector(".MainBox")
const Movement_Details = document.querySelectorAll(".Hide")


Btn_Deteils.addEventListener("click", ()=>{

    if (MainBox.classList.contains("MainBox_Select")) {

        MainBox.classList.remove("MainBox_Select")
        Btn_Deteils.innerHTML="Mais Detalhes"
        
		for (var i = 0; i < 8; i++) {
		  ((i)=> {
		    setTimeout(()=> {
				Movement_Details.item(Movement_Details.length - i).classList.remove("Show")
				
				if (i > 2) {
					Movement_Details.item((Movement_Details.length - i)-5).classList.remove("Show")					
				}

		    }, 80*i);
		  })(i);
		};

    } else {

        MainBox.classList.add("MainBox_Select")
        Btn_Deteils.innerHTML="Menos Detalhes"

		for (var i = 0; i < 7; i++) {
		  ((i)=> {
		    setTimeout(()=> {
				Movement_Details.item(i).classList.add("Show")
				Movement_Details.item(i+5).classList.add("Show")
		    }, 80*i);
		  })(i);
		};
		
    }

})
