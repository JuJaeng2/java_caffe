const signupLogin = document.querySelector("#signup");
const loginLogin = document.querySelector("#login");
const loginForm = document.querySelector(".login-form");
const signupForm = document.querySelector(".signup-form");

signupLogin.addEventListener("click", () => {
  loginForm.style.display = "none";
  signupForm.style.display = "block";
});

loginLogin.addEventListener("click", () => {
  loginForm.style.display = "block";
  signupForm.style.display = "none";
});