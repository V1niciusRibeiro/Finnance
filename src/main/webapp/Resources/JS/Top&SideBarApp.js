
const menu_button= document.querySelector(".menu_button");
const nav= document.querySelector(".nav");
const close_button= document.querySelector(".close_button");
const overlay= document.querySelector(".overlay");

const profile_button= document.querySelector(".profile_button");
const profile= document.querySelector(".profile")
menu_button.addEventListener("click", () => {
	nav.classList.toggle("active")
	overlay.classList.toggle("active")
	}, false)			
close_button.addEventListener("click", () => {
	nav.classList.remove("active")
	overlay.classList.remove("active")
	}, false)
	
profile_button.addEventListener("click", () => {profile.classList.toggle("active")}, false)

