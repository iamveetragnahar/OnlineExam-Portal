<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
String usernameFromSession = (String)session.getAttribute("EnrollmentNumber");
String uType=(String)session.getAttribute("uType"); 
String username= request.getParameter("userName");
String password= request.getParameter("password");

	if(usernameFromSession==null||!usernameFromSession.equals(username)){
		response.sendRedirect("index.html");
	}
String image= (String)session.getAttribute("imgPath");
String name=(String)session.getAttribute("name");
%>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Document</title>
            <script src="https://cdn.tailwindcss.com"></script>
            <script src="https://kit.fontawesome.com/e7c33eb849.js" crossorigin="anonymous"></script>
            <script src='https://code.jquery.com/jquery-3.6.0.min.js' integrity='sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=' crossorigin='anonymous'></script>
            <style>
                @import url('https://fonts.googleapis.com/css2?family=Roboto&display=swap');
                @import url('https://fonts.googleapis.com/css2?family=Courgette&display=swap');
                @import url('https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap');
                @import url('https://fonts.googleapis.com/css2?family=Lato:ital@1&display=swap');
                .bg {
                    width: 100%;
                    height: 100vh;
                    position: fixed;
                    top: 0;
                    left: 0;
                    z-index: -111111;
                }
                
                body {
                    font-family: sans-serif;
                    /* font-weight: 700; */
                }
                
                .bg>img {
                    width: 100%;
                    height: 100%;
                }
                
                .input:focus {
                    box-shadow: 0px 0px 6px white;
                }
                
                nav {
                    font-family: 'Courgette', cursive;
                }
                
                .font-Courgette {
                    font-family: 'Courgette', cursive;
                }
                
                .font-Lato {
                    font-family: 'Lato', sans-serif;
                }
                
                .w-fullA {
                    width: 90%;
                }
                
                .disabled-button {
                    opacity: 0.6;
                    /* background-color: red; */
                }
                
                .h-90 {
                    max-height: 90vh;
                }
                
                .hiddenScrollBar::-webkit-scrollbar {
                    display: none;
                }
            </style>
        </head>


        <body class="">
            <input type='hidden' class='hidden' id='usernameId' value='<%= username %>'>
            <input type='hidden' class='hidden' id='uType' value='<%= uType %>'>
            <div class="bg">
                <img src="imgs/bg1br15.png" alt="">
            </div>
            <!-- <nav style=" box-shadow: 0px 0px 6px black;" id="nav" class="md:bg-white/50 bg-white/90 top-0  w-full z-50 h-full fixed transition-all duration-200  md:left-0 md:w-1/5 -left-full lg:w-1/5"> -->
            <nav style=" box-shadow: 0px 0px 6px black;" id="nav" class="md:bg-white/50 bg-white/90  h-full fixed transition-all duration-200 -left-full md:left-0 top-0  w-full z-50 md:lg:w-1/5">
                <i class="fas fa-bars  icons_control fixed top-3 right-3  text-2xl md:hidden" id="bars"></i>
                <i class="fas fa-times icons_control fixed top-3 right-3 text-2xl hidden md:hidden" id="close"></i>
                <div id="profileImg">
                    <div id="img" class="  pt-10 m-1">
                        <img src="imgs/<%= image %>" alt="" class="aspect-square rounded-full w-1/3 md:w-7/12  p-1  m-auto">
                    </div>
                    <div class=" m-0">
                        <p class="text-center text-xl m-0 p-0 leading-none">
                            <%= name %>
                        </p>
                        <p class="text-center text-md m-1 p-0 leading-none">Student</p>
                    </div>
                </div>

                <ul class="ml-6 my-10  border-0 border-black overflow-x-auto overflow-y-auto">
                    <li class=" mr-5 md:ml-7 text-xl my-5  border-b-2 border-black md:border-none flex justify-center md:block "><i class=" mr-3 text-black text-center md:text-left md:text-white  fas fa-home "></i> <a class="hover:pl-1 transition-all hover:font-bold " href="#" onclick='showProfile()'> Profile </a></li>
                    <!--   <li class=" mr-5 md:ml-7 text-xl my-5  border-b-2 border-black md:border-none flex justify-center md:block "><i class=" mr-3 text-black text-center md:text-left md:text-white  fas fa-user"></i> <a class="hover:pl-1 transition-all hover:font-bold" href="#"> Update</a></li> -->
                    <li class=" mr-5 md:ml-7 text-xl my-5  border-b-2 border-black md:border-none flex justify-center md:block "><i class=" mr-3 text-black text-center md:text-left md:text-white fas fa-file "></i> <a class="hover:pl-1 transition-all hover:font-bold" href="#" onclick="showNotices()"> Notice</a></li>
                    <li class=" mr-5 md:ml-7 text-xl my-5  border-b-2 border-black md:border-none flex justify-center md:block "><i class=" mr-3 text-black text-center md:text-left md:text-white  fas fa-file-alt"></i> <a class="hover:pl-1 transition-all hover:font-bold" href=" # " onclick='showAllTest()'> Give Test</a></li>
                    <li class=" mr-5 md:ml-7 text-xl my-5  border-b-2 border-black md:border-none flex justify-center md:block "><i class=" mr-3 text-black text-center md:text-left md:text-white fas fa-file "></i> <a class="hover:pl-1 transition-all hover:font-bold" href="#" onclick='showResults()'> Results</a></li>
                    <li class=" mr-5 md:ml-7 text-xl my-5  border-b-2 border-black md:border-none flex justify-center md:block "><i class=" mr-3 text-black text-center md:text-left md:text-white fas fa-file "></i> <a class="hover:pl-1 transition-all hover:font-bold" href="#" onclick='availableAnsSheet()'> Check Answer Sheets</a></li>
                    <li class=" mr-5 md:ml-7 text-xl my-5  border-b-2 border-black md:border-none flex justify-center md:block "><i class=" mr-3 text-black text-center md:text-left md:text-white  fas fa-key"></i> <a class="hover:pl-1 transition-all hover:font-bold " href=" # " onclick='changePassword()'> Change Password</a></li>
                    <li class=" mr-5 md:ml-7 text-xl my-5  border-b-2 border-black md:border-none flex justify-center md:block "><i class=" mr-3 text-black text-center md:text-left md:text-white fas fa-sign-out-alt "></i> <a class="hover:pl-1 transition-all hover:font-bold" href="Logout"> Log out</a></li>

                </ul>

                <div class=" text-lg absolute hidden  lg:block w-full bottom-2 ">
                    <p class="text-center"><span class="text-white text-center"> copyright</span> <i class="far fa-copyright"></i>ips academy</p>
                    <p class="text-center">indore</p>
                </div>

            </nav>
            <div id="rightBox" class="w-full  md:w-4/5 h-full  fixed top-0 right-0">

                <!-- <div style="background-color: rgba(0,0,0,0.5);" class=" border-black w-fullA md:w-4/5  h-4/5 rounded-md absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2">

                    <div id="profileImg" class="font-Courgette absolute hidden md:block  md:w-1/4 left-0 top-1/2 -translate-y-full">
                        <div id="img" class="  m-1">
                            <img src="imgs/user1.jpeg" alt="" class=" rounded-full w-3/4  p-1  m-auto">
                        </div>
                        <div class=" m-0">
                            <p class="text-center text-xl m-0 p-0 leading-none">Juned Khan</p>
                            <p class="text-center text-md m-1 p-0 leading-none">Student</p>
                        </div>
                    </div>
                    <div class=" w-3/4 px-12 h-full absolute right-1/2 translate-x-1/2 md:-translate-x-0 md:right-4">
                        <div class=" p-4 rounded-md font-Lato absolute w-full left-1/2 top-1/2 -translate-x-1/2 -translate-y-1/2   bg-white/60 ">
                            <div>

                                <div class="text-white text-xl m-3">
                                    <span class="pl-2">Name:</span>
                                    <span class="pl-2">Juned Khan</span>
                                </div>
                                <div class="text-white text-xl m-3">
                                    <span class="pl-2">Enrollment No:</span>
                                    <span class="pl-2">0808CS191091</span>
                                </div>
                                <div class="text-white text-xl m-3">
                                    <span class="pl-2">D.O.B:</span>
                                    <span class="pl-2">02/09/2000</span>
                                </div>
                                <div class="text-white text-xl m-3">
                                    <span class="pl-2">Gender:</span>
                                    <span class="pl-2">Male</span>
                                </div>
                                <div class="text-white text-xl m-3">
                                    <span class="pl-2">Course:</span>
                                    <span class="pl-2">B.Tech CS</span>
                                </div>
                                <div class="text-white text-xl m-3">
                                    <span class="pl-2">Batch:</span>
                                    <span class="pl-2">2019-23</span>
                                </div>
                                <div class="text-white text-xl m-3">
                                    <span class="pl-2">Email:</span>
                                    <span class="pl-2">juned7734@gmail.com</span>
                                </div>
                                <div class="text-white text-xl m-3">
                                    <span class="pl-2">Mobile:</span>
                                    <span class="pl-2">9993602439</span>
                                </div>
                            </div>
                            <div>
                                <input type="button" value="Edit Profile" class="bg-blue-600 hover:bg-blue-700 py-2 px-4 rounded-md text-white m-3">
                            </div>


                        </div>

                    </div>

                </div>  -->

                <div style="background-color: rgba(0,0,0,0.5);" class=" border-black w-fullA md:w-1/3  h-auto py-8 rounded-md absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2">

                    <div class="font-Lato">
                        <!-- <form method="POST" action="" id="form"> -->
                        <h1 class="text-white text-center text-3xl font-bold">Change Password</h1>
                        <!-- error box  -->

                        <div id="errorbox" class="hidden text-center text-red-700 bg-red-400  border-2 rounded-md border-red-700 w-4/5 m-auto">
                            Username/Password is wrong
                        </div>
                        <div id="succesboxmsg" class="hidden text-center text-green-700 bg-green-400  border-2 rounded-md border-green-700 w-4/5 m-auto">
                            Username/Password is wrong
                        </div>

                        <div class="m-7 sm:mx-12 relative">
                            <input type="password" id="oldPassword" name="password" class="p-3 input field text-black w-full rounded-md focus:border-none focus:box focus:outline-none" placeholder="Enter Old Password">
                            <i id="eye" onclick="Eye(this)" class="fas fa-eye text-black absolute right-3 top-1/2  -translate-y-1/2 "></i>
                            <i id="eye_slash" onclick="EyeSlash(this)" class="fas fa-eye-slash text-black absolute right-3 top-1/2 -translate-y-1/2  hidden  "></i>
                        </div>
                        <div class="m-7 sm:mx-12 relative">
                            <input type="password" id="newPassword" name="password" class="p-3 input field text-black w-full rounded-md focus:border-none focus:box focus:outline-none" placeholder="Enter New Password">
                            <i id="eye" onclick="Eye(this)" class="fas fa-eye text-black absolute right-3 top-1/2 -translate-y-1/2 "></i>
                            <i id="eye_slash" onclick="EyeSlash(this)" class="fas fa-eye-slash text-black absolute right-3 top-1/2 -translate-y-1/2 hidden "></i>
                        </div>
                        <div class="m-7 sm:mx-12 relative ">
                            <input type="password" id="confirmPassword" name="password " class="p-3 input field text-black w-full rounded-md focus:border-none focus:box focus:outline-none " placeholder="Confirm Password ">
                            <i id="eye " onclick="Eye(this) " class="fas fa-eye text-black absolute right-3 top-1/2 -translate-y-1/2 "></i>
                            <i id="eye_slash " onclick="EyeSlash(this)" class="fas fa-eye-slash text-black absolute right-3 top-1/2 -translate-y-1/2 hidden "></i>
                        </div>
                        <!-- login button -->
                        <div>
                            <input type="submit" id="submit" value="Submit " class=" bg-blue-500 hover:bg-blue-600 text-center text-white px-7   py-2 text-2xl rounded block m-auto ">
                        </div>

                        <script src="passwordreset.js">
                        </script>
                        <!-- </form> -->
                    </div>


                </div>

            </div>


        </body>
        <script>
            let usernameId = document.getElementById('usernameId').value;
            let uType = document.getElementById('uType').value;
            let rightBox = document.getElementById('rightBox');
	console.log('hello script is lpaed');

            showProfile();
            //handling navbar on reponsive 
            let bars = document.getElementById('bars');
            let close = document.getElementById('close');
            let nav = document.getElementById('nav');

            bars.addEventListener('click', () => {
                nav.classList.remove('-left-full');
                nav.classList.add('left-0');
                bars.classList.add('hidden');
                close.classList.remove('hidden');

            });

            function closeNav() {
                nav.classList.add('-left-full');
                nav.classList.remove('left-0');
                bars.classList.remove('hidden');
                close.classList.add('hidden');

            }
            //closeNav();

            close.addEventListener('click', () => {
                nav.classList.add('-left-full');
                nav.classList.remove('left-0');
                bars.classList.remove('hidden');
                close.classList.add('hidden');

            });
            //****************************************************
            //function to show profile
            function showProfile() {

                let xml = new XMLHttpRequest();
                xml.onload = function() {
                    console.log(xml.responseText);

                    rightBox.innerHTML = xml.responseText;
                    closeNav();
                }
                xml.open("GET", 'ShowProfile?username=' + usernameId + "&uType=" + uType, "yes");
                xml.send();
            }
            //***********************************************************

            //fucntion to replace the content to change the password

            function changePassword() {
            	console.log('change paswword is activated');
                let xml = new XMLHttpRequest();
                xml.onload = function() {
                    console.log(xml.responseText);
                    //import { hello }	 from './module.js';
                    rightBox.innerHTML = xml.responseText;
                    closeNav();
                }
                xml.open("GET", 'ChangePasswordUI?username=' + usernameId + "&uType=" + uType, "yes");
                xml.send();

            }
            // **********************************

            function changePasswordButton(ele) {
                let oldPassword = document.getElementById('oldPassword');
                let newPassword = document.getElementById('newPassword');
                let confirmPassword = document.getElementById('confirmPassword');
                let submit = ele;
                console.log('submit button');
                if (oldPassword.value == '' || newPassword.value == '' || confirmPassword.value == '') {
                    showError('empty field');
                    return;
                }
                let xml = new XMLHttpRequest();

                xml.onload = function() {
                    let ot = xml.responseText;
                    console.log("response text is :" + ot);

                    try {
                        ot = Number(ot);

                    } catch (error) {
                        console.log(error);
                        showError('password not changed!');
                        return;

                    }

                    if (ot == 1) {
                        succesboxmsg("Password changed successfully");
                        oldPassword.value = '';
                        newPassword.value = '';
                        confirmPassword.value = '';

                    } else if (ot == 0) {
                        showError("old password is wrong");
                    } else {
                        showError('password not changed');
                    }
                }
                xml.open('GET', 'ChangePassword1?utype=student&oldPassword=' + oldPassword.value + '&newPassword=' + newPassword.value, 'yes');
                xml.send();
            }

            function passwordConfirmByNewPassword(ele) {
                let cp = document.getElementById('confirmPassword').value;
                let np = ele.value;
                let submit = document.getElementById('passwordChangeSubmit');
                console.log(np.substr(0, 3));
                if (cp.length == '')
                    return;


                if (cp.substr(0, np.length) != np) {
                    showError('confirom and new password not matches');
                    submit.disabled = true;
                    submit.classList.add('disabled-button');
                } else {
                    submit.disabled = false;
                    submit.classList.remove('disabled-button');
                }

            }

            function passwordConfirmByConfirmPassword(ele) {
                let cp = ele.value;
                let np = document.getElementById('newPassword').value;
                let submit = document.getElementById('passwordChangeSubmit');
                console.log(np.substr(0, 3));

                if (np.substr(0, cp.length) != cp) {
                    showError('confirom and new password not matches');
                    submit.disabled = true;
                    submit.classList.add('disabled-button');
                } else {
                    submit.disabled = false;
                    submit.classList.remove('disabled-button');
                }

            }

            // *******************************************
            // show all test 
            function showAllTest() {
                closeNav();
                let xml = new XMLHttpRequest();
                xml.onload = function() {
                    console.log(xml.responseText);
                    rightBox.innerHTML = xml.responseText;
                }
                xml.open("GET", "ShowAllTestToStudent?StudentId=" + usernameId, "YES");
                xml.send();

            }

            function GenerateTestPapar(btn) {
                console.log(btn.value);
                console.log(btn.id);
                closeNav();

                let xml = new XMLHttpRequest();
                xml.onload = function() {
                    console.log(xml.responseText);
                    rightBox.innerHTML = xml.responseText;

                }
                xml.open("GET", "GenerateTestPapar?TestId=" + btn.id + "&StudentId=" + btn.value, "YES");
                xml.send();


            }

            function SubmitTest(eve, form) {
                eve.preventDefault();
                console.log("default prevented");
                console.log(form);


                console.log('formd data');
                let data = '';
                let fr = new FormData(form);
                Array.from(fr).forEach(ele => {
                    console.log(ele);
                    data += ele[0] + '=' + ele[1] + "&";
                });
                data = data.substr(0, data.length - 1);
                console.log(data);


                let xml = new XMLHttpRequest();
                xml.onload = function() {
                	console.log(xml.response.text);
                    rightBox.innerHTML = xml.responseText;
                };

  //              xml.onload = function() {
                    //let rdz = xml.responseText;
                    //rdz = (Number)rdz;
                    //if (rdz == 1) {

                    //}
//                }
                xml.open("POST", "SubmitTest", "YES");
                xml.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                // xml.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                xml.send(data);



            }

            function availableAnsSheet() {
                closeNav();

                console.log('available ans sheets');
                let xml = new XMLHttpRequest();
                xml.onload = function() {
                    rightBox.innerHTML = xml.responseText;
                }
                xml.open("GET", "ShowAvailableAnsSheet?StudentId=" + usernameId, "YES");
                xml.send();
            }

            function generateAnsSheet(btn) {

                console.log(btn.value);
                let xml = new XMLHttpRequest();

                xml.onload = function() {
                    console.log(xml.responseText);

                    rightBox.innerHTML = xml.responseText;

                }
                xml.open("GET", "AnswerSheet?TestId=" + btn.value, "YES");
                xml.send();
            }

            function showNotices() {
                console.log("show notices is worknig ");
                let xml = new XMLHttpRequest();
                xml.onload = function() {

                    console.log("inside onload");
                    rightBox.innerHTML = xml.responseText;
                }
                xml.open("GET", "ShowNotices?userType=Student", "YES");
                xml.send();
            }

            //**********************************************************
            function showResults() {
                let xml = new XMLHttpRequest();
                xml.onload = function() {
                    rightBox.innerHTML = xml.responseText;
                }
                xml.open("GET", "ShowResults?StudentId=" + usernameId, "YES");
                xml.send();
            }

            function showResult(btn) {
                let resultId = btn.id;
                let xml = new XMLHttpRequest();
                xml.onload = function() {
                    rightBox.innerHTML = xml.responseText;
                }
                xml.open("GET", "ShowResult?ResultId=" + resultId, "YES");
                xml.send();
            }

            // handling input hide and show even 
            function Eye(ele) {
                let input = ele.previousElementSibling;
                let eye_slash = ele.nextElementSibling;

                input.type = "text ";
                eye_slash.classList.remove('hidden');
                ele.classList.add('hidden');
            }

            function EyeSlash(ele) {
                let input = ele.previousElementSibling.previousElementSibling;
                let eye = ele.previousElementSibling;

                input.type = 'password';
                ele.classList.add('hidden');
                eye.classList.remove('hidden');
            }

            //**********************************************************
            // erro msg function  
            function showError(msg) {
                let errorbox = document.getElementById('errorbox');
                errorbox.classList.remove('hidden');
                errorbox.innerText = msg;
                setTimeout(() => {
                    errorbox.classList.add('hidden');
                }, 5000);

            }
            // success msg fucntion 
            function succesboxmsg(msg) {
                let succesboxmsg = document.getElementById('successbox');
                succesboxmsg.classList.remove('hidden');
                succesboxmsg.innerText = msg;
                setTimeout(() => {
                    succesboxmsg.classList.add('hidden');
                }, 5000);
            }
        </script>

        </html>