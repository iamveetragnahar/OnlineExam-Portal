<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
String usernameFromSession = (String)session.getAttribute("email");
String uType=(String)session.getAttribute("uType"); 
String username= request.getParameter("userName");
String password= request.getParameter("password");

	if(usernameFromSession==null||!usernameFromSession.equals(username)){
		response.sendRedirect("index2.html");
		out.println("<h1 class='text-white text-3xl' >"+usernameFromSession+" "+username +"</h1'>");
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
                
                .hiddenScrollBar::-webkit-scrollbar {
                    display: none;
                }
                
                .w-fullA {
                    width: 90%;
                }
                
                .disabled-button {
                    opacity: 0.6;
                    /* background-color: red; */
                }
            </style>
        </head>


        <body class="">
            <input type="hidden" id="uesrnameInp" value="<%= username %>">
            <div class="bg">
                <img src="imgs/bg1br15.png" alt="">
            </div>
            <nav style=" box-shadow: 0px 0px 6px black;" id="nav" class=" md:bg-white/50 bg-white/90  h-full fixed transition-all duration-200 -left-full md:left-0 top-0  w-full z-50 md:lg:w-1/5">
                <i class="fas fa-bars  icons_control fixed top-3 right-3  text-2xl md:hidden" id="bars"></i>
                <i class="fas fa-times icons_control fixed top-3 right-3 text-2xl hidden md:hidden" id="close"></i>
                <div id="profileImg">
                    <div id="img" class="  pt-10 m-1">
                        <img src="imgs/<%= image %>" alt="" class="rounded-full aspect-square w-1/3 md:w-7/12  p-1  m-auto">
                    </div>
                    <div class=" m-0">
                        <p class="text-center text-xl m-0 p-0 leading-none" id="navBarName">
                            <%= name %>
                        </p>
                        <p class="text-center text-md m-1 p-0 leading-none">Examiner</p>
                    </div>
                </div>

                <ul class="ml-6 my-10 h-1/2 overflow-x-auto overflow-y-auto hiddenScrollBar">
                    <li class=" mr-5 md:ml-7 text-xl my-5   border-b-2 border-black md:border-none flex justify-center md:block "><i class=" mr-3 text-black text-center md:text-left md:text-white  fas fa-home "></i> <a class="hover:pl-1 transition-all hover:font-bold " href="#" onclick="showProfile()"> Profile </a></li>
                    <li class=" mr-5 md:ml-7 text-xl my-5   border-b-2 border-black md:border-none flex justify-center md:block "><i class=" mr-3 text-black text-center md:text-left md:text-white  fas fa-user"></i> <a class="hover:pl-1 transition-all hover:font-bold" href="#" onclick="showTeacherUpdateForm()">Update</a></li>
                    <li class=" mr-5 md:ml-7 text-xl my-5   border-b-2 border-black md:border-none flex justify-center md:block "><i class=" mr-3 text-black text-center md:text-left md:text-white  fas fa-user"></i> <a class="hover:pl-1 transition-all hover:font-bold" href="#" onclick="showNotices()">Manage Notice</a></li>
                    <li class=" mr-5 md:ml-7 text-xl my-5   border-b-2 border-black md:border-none flex justify-center md:block"><i class=" mr-3 text-black text-center md:text-left md:text-white  fas fa-file-alt"></i> <a class="hover:pl-1 transition-all hover:font-bold" href=" # " onclick="addTestForm()">Add Test</a></li>
                    <li class=" mr-5 md:ml-7 text-xl my-5   border-b-2 border-black md:border-none flex justify-center md:block "><i class=" mr-3 text-black text-center md:text-left md:text-white fas fa-file "></i> <a class="hover:pl-1 transition-all hover:font-bold" href="#" onclick="allTestUI()">All Test</a></li>
                    <li class=" mr-5 md:ml-7 text-xl my-5   border-b-2 border-black md:border-none flex justify-center md:block "><i class=" mr-3 text-black text-center md:text-left md:text-white  fas fa-solid fa-graduation-cap"></i> <a class="hover:pl-1 transition-all hover:font-bold " href=" # " onclick="addStudentFormUI()">Add Student</a></li>
                    <li class=" mr-5 md:ml-7 text-xl my-5   border-b-2 border-black md:border-none flex justify-center md:block "><i class=" mr-3 text-black text-center md:text-left md:text-white  fas fa-solid fa-school"></i> <a class="hover:pl-1 transition-all hover:font-bold " href=" # " onclick="allStudentUI()">All Student</a></li>
                    <li class=" mr-5 md:ml-7 text-xl my-5   border-b-2 border-black md:border-none flex justify-center md:block "><i class=" mr-3 text-black text-center md:text-left md:text-white  fas fa-solid fa-paste"></i> <a class="hover:pl-1 transition-all hover:font-bold " href=" # " onclick="visibleAnswers()">Visible Answers</a></li>
                    <li class=" mr-5 md:ml-7 text-xl my-5   border-b-2 border-black md:border-none flex justify-center md:block "><i class=" mr-3 text-black text-center md:text-left md:text-white  fas fa-key"></i> <a class="hover:pl-1 transition-all hover:font-bold " href=" # " onclick="changePassword()">Change Password</a></li>
                    <li class=" mr-5 md:ml-7 text-xl my-5   border-b-2 border-black md:border-none flex justify-center md:block "><i class=" mr-3 text-black text-center md:text-left md:text-white fas fa-sign-out-alt "></i> <a class="hover:pl-1 transition-all hover:font-bold" href="Logout"> Log out</a></li>

                </ul>

                <div class=" text-lg absolute hidden  lg:block w-full bottom-0 ">
                    <p class="text-center"><span class="text-white text-center"> copyright</span> <i class="far fa-copyright"></i>ips academy</p>
                    <p class="text-center">indore</p>
                </div>

            </nav>
            <div id="rightBox" class="w-full  md:w-4/5 h-full  fixed top-0 right-0">

                <div style="background-color: rgba(0,0,0,0.5);" class=" border-black w-fullA md:w-4/5  h-2/3 rounded-md absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2">

                </div>

            </div>


        </body>
        <script>
            let usernameId = document.getElementById('uesrnameInp').value;
            let bars = document.getElementById('bars');
            let close = document.getElementById('close');
            let nav = document.getElementById('nav');
            showProfile();
            bars.addEventListener('click', () => {
                nav.classList.remove('-left-full');
                nav.classList.add('left-0');
                bars.classList.add('hidden');
                close.classList.remove('hidden');

            });

            close.addEventListener('click', () => {
                nav.classList.add('-left-full');
                nav.classList.remove('left-0');
                bars.classList.remove('hidden');
                close.classList.add('hidden');

            })

            function closeNav() {
                nav.classList.add('-left-full');
                nav.classList.remove('left-0');
                bars.classList.remove('hidden');
                close.classList.add('hidden');
            }



            // handling hide and show input field 
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

            //function to show profile
            function showProfile() {

                let xml = new XMLHttpRequest();
                xml.onload = function() {
                    console.log(xml.responseText);

                    rightBox.innerHTML = xml.responseText;
                    closeNav();
                    //closeNav();
                }
                console.log(usernameId);
                xml.open("GET", "ShowProfile?username=" + usernameId + "&uType=teacher", "yes");
                xml.send();
            }



            // fucntion to update details of teacher 
            function updateTeacherDetails() {
                let UpdateNameInp = document.getElementById('UpdateNameInp').value;
                let UpdateQualificationInp = document.getElementById('UpdateQualificationInp').value;
                let UpdateMobileInp = document.getElementById('UpdateMobileInp').value;
                let UpdateEmailInp = document.getElementById('UpdateEmailInp').value;
                console.log(UpdateEmailInp);
                if (UpdateEmailInp == '' || UpdateMobileInp == '' || UpdateQualificationInp == '' || UpdateNameInp == '') {
                    showError("Empty field");
                    return;
                }

                let mobPat = /[0-9]{10}/;
                if (!(mobPat.test(UpdateMobileInp)) && !(UpdateMobileInp.length == 10)) {
                    showError("mobile is not correct");
                    return;
                }

                let emailPat = /(\w+)(@gmail.com)/;
                // console.log(UpdateEmailInp.match(emailPat));
                console.log(emailPat.test(UpdateEmailInp));
                if (!emailPat.test(UpdateEmailInp)) {
                    showError("please enter valid gmail");
                    return
                }

                let xml = new XMLHttpRequest();
                xml.onload = function() {
                        console.log(xml.responseText);

                        let rt = Number(xml.responseText);
                        if (rt == 1) {
                            usernameId = UpdateEmailInp;
                            document.getElementById("navBarName").innerText = UpdateNameInp;
                            succesboxmsg("details updated successfully");
                        } else if (rt == 0)
                            showError("details not updated.");
                        else
                            showError("details not updated due to error");
                        document.getElementById('UpdateNameInp').value = '';
                        document.getElementById('UpdateQualificationInp').value = '';
                        document.getElementById('UpdateMobileInp').value = '';
                        document.getElementById('UpdateEmailInp').value = '';
                    }
                    // xml.setRequestHeader("Content-Type", "application/x-www-from-urlencoded");

                xml.open("POST", "UpdateTeacherDetails", "YES");
                xml.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                xml.send("username=" + usernameId + "&newname=" + UpdateNameInp + "&newqualification=" + UpdateQualificationInp + "&newmobilenumber=" + UpdateMobileInp + "&newemail=" + UpdateEmailInp);
            }
            // **********************************************************************
            function showTeacherUpdateForm() {

                let xml = new XMLHttpRequest();
                xml.onload = function() {
                    console.log(xml.responseText);

                    rightBox.innerHTML = xml.responseText;
                    //closeNav();
                    closeNav();
                }
                console.log(usernameId);
                xml.open("GET", "ShowTeacherUpdateForm?username=" + usernameId + "&uType=teacher", "yes");
                xml.send();


            }







            //fucntion to replace the content to change the password

            function changePassword() {
                let xml = new XMLHttpRequest();
                xml.onload = function() {
                    console.log(xml.responseText);
                    //import { hello }	 from './module.js';
                    rightBox.innerHTML = xml.responseText;
                    closeNav();
                }
                xml.open("GET", 'ChangePasswordUI?username=' + usernameId + "&uType=teacher", "yes");
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
                if (confirmPassword.value != newPassword.value) {
                    console.log(confirmPassword.value);
                    console.log(newPassword.value);
                    showError('confirom and new password not matches');
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
                console.log(np.substr(0, cp.length));
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
                console.log(cp.substr(0, np.length));

                if (np.substr(0, cp.length) != cp) {
                    showError('confirom and new password not matches');
                    submit.disabled = true;
                    submit.classList.add('disabled-button');
                } else {
                    submit.disabled = false;
                    submit.classList.remove('disabled-button');
                }

            }

            ///********************************************************************
            //add test form 
            function addTestForm() {
                let xml = new XMLHttpRequest();
                xml.onload = function() {
                    console.log(xml.responseText);
                    //import { hello }	 from './module.js';
                    rightBox.innerHTML = xml.responseText;
                    closeNav();
                }
                xml.open("GET", 'AddTestFormUI', "yes");
                xml.send();
            }



            //addint test title to the database 
            function addTestTitleAndDetails() {
                let testtitle = document.getElementById('testTitleInp').value;
                let branchSelect = document.getElementById('branchSelect').value;
                let courseselect = document.getElementById('courseselect').value;
                let year = document.getElementById('Year').value;
                let semester = document.getElementById('Semester').value;
                let milis = new Date().getTime();
                console.log(milis);
                console.log(testtitle);
                console.log(branchSelect);
                console.log(courseselect);
                console.log(year);
                console.log(semester);




                if (testtitle == '' || branchSelect == '' || courseselect == '') {
                    showError("Empty Field");
                    document.getElementById('testTitleInp').parentElement.parentElement.scrollBehavior = 'smooth';
                    document.getElementById('testTitleInp').parentElement.parentElement.scrollBy(0, -200);
                    return;
                }

                let xml = new XMLHttpRequest();
                xml.onload = function() {
                    milis = String(milis);
                    let rt = xml.responseText;
                    console.log(rt);
                    try {
                        rt = Number(rt);
                    } catch (error) {
                        console.log(error);
                        rt = 0;
                    }
                    console.log(rt);
                    console.log(milis);

                    if (rt == 1) {
                        succesboxmsg("Test inserted successfully...");
                        document.getElementById('testTitleInp').parentElement.parentElement.scrollBehavior = 'smooth';
                        document.getElementById('testTitleInp').parentElement.parentElement.scrollBy(0, -300);
                        setTimeout(() => {

                            let xml1 = new XMLHttpRequest();
                            xml1.onload = function() {
                                rightBox.innerHTML = xml1.responseText;
                            }
                            xml1.open("GET", "AddQuestionByTeacherUI?testId=" + milis);
                            xml1.send();

                        }, 2000);

                    } else {
                        document.getElementById('testTitleInp').parentElement.parentElement.scrollBehavior = 'smooth';
                        document.getElementById('testTitleInp').parentElement.parentElement.scrollBy(0, -300);
                        showError("same Test title already exist");
                        return;
                    }


                }
                xml.open("POST", "AddTestTitleAndDetails", "YES");
                xml.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xml.send("testTitle=" + testtitle + "&branch=" + branchSelect + "&course=" + courseselect + "&testId=" + milis + " &year=" + year + "&semester=" + semester);




            }

            // fucntion to add tets questions;
            function addQuestion() {
                let testId = document.getElementById('testId').value;
                let Question = document.getElementById('testQuestionInp').value;
                let option1 = document.getElementById('option1').value;
                let option2 = document.getElementById('option2').value;
                let option3 = document.getElementById('option3').value;
                let option4 = document.getElementById('option4').value;
                let optionSelect = document.getElementById('optionSelect').value;
                console.log(testId);
                1

                if (Question == '' || option1 == '' || option2 == '' || option3 == '' || option4 == '') {
                    document.getElementById('testId').parentElement.parentElement.scroll(0, -200);
                    document.getElementById('testId').parentElement.parentElement.scrollBehavior = 'smooth';
                    showError('Empty field');

                    return;
                }

                let xml = new XMLHttpRequest();
                xml.onload = function() {
                    let rt = xml.responseText;
                    console.log(rt);
                    if (rt == 1) {
                        document.getElementById('testId').parentElement.parentElement.scrollBehavior = 'smooth';
                        document.getElementById('testId').parentElement.parentElement.scroll(0, -200);
                        succesboxmsg("Questions added successfully");
                    } else
                        document.getElementById('testId').parentElement.parentElement.scrollBehavior = 'smooth';
                    document.getElementById('testId').parentElement.parentElement.scroll(0, -220);
                    showError("Question already exist");
                }
                xml.open("POST", "AddTestQuestions", "YES");
                // xml.setRequestHeader("ContentType", "")
                xml.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xml.send("testId=" + testId + "&question=" + Question + "&option1=" + option1 + "&option2=" + option2 + "&option3=" + option3 + "&option4=" + option4 + "&correctSelect=" + optionSelect);
            }
            //  *******************************************************************************************************
            // fucntion to add all Test uI
            function allTestUI() {
                closeNav();
                let xml = new XMLHttpRequest();
                xml.onload = function() {
                    rightBox.innerHTML = xml.responseText;
                }
                xml.open("GET", "AllTestUI", "YES")
                xml.send();
            }
            // ************************88
            //  function to delete test 
            function deleteTest(ele) {
                if (!window.confirm("Are You sure You want to Delete This Test?")) {
                    return;
                }
                let testId = ele.value;

                let xml = new XMLHttpRequest();

                xml.onloadend = function() {

                    console.log(xml.responseText);
                    console.log(ele.parentElement.parentElement);

                    ele.parentElement.parentElement.remove();

                }
                xml.open("GET", "DeteteTest?testId=" + testId, "YES");
                xml.send();
            }
            // ************************************************************************8
            function activeButton(btn) {
                let testId = btn.value;
                console.log(testId);
                let xml = new XMLHttpRequest();
                xml.onload = function() {
                    let rt = xml.responseText;
                    rt = Number(rt);
                    if (rt == 1) {
                        let nxt = btn.nextElementSibling;
                        btn.classList.add('hidden');
                        nxt.classList.remove('hidden');
                    } else {
                        console.log(rt);
                    }

                }
                xml.open("GET", "ChangeStatusOfTest?testId=" + testId + "&status=1", "YES");
                xml.send();

            }

            function notActiveButton(btn) {
                let testId = btn.value;
                console.log(testId);
                let xml = new XMLHttpRequest();
                xml.onload = function() {
                    let rt = xml.responseText;
                    rt = Number(rt);
                    if (rt == 1) {
                        let pre = btn.previousElementSibling;
                        btn.classList.add('hidden');
                        pre.classList.remove('hidden');
                    } else {
                        console.log(rt);
                    }

                }
                xml.open("GET", "ChangeStatusOfTest?testId=" + testId + "&status=0", "YES");
                xml.send();

            }



            // *****************************************************************
            function addEditTestUI(btn) {
                let xml = new XMLHttpRequest();
                xml.onload = function() {
                    console.log(xml.responseText);
                    rightBox.innerHTML = xml.responseText;
                }
                xml.open("GET", "AddEditTestUI?testId=" + btn.value, "YES");
                // xml.setRequestHeader("Content-type",)
                // xml.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

                xml.send();
            }

            function addQuestionsByButton(btn) {
                console.log(btn.value);

                let xml1 = new XMLHttpRequest();
                xml1.onload = function() {
                    rightBox.innerHTML = xml1.responseText;
                }
                xml1.open("GET", "AddQuestionByTeacherUI?testId=" + btn.value);
                xml1.send();

            }

            function submitHead(btn) {
                let pre = btn.parentElement.parentElement;
                let first = pre.firstElementChild;
                let second = first.nextElementSibling;
                let third = second.nextElementSibling;
                let testId = btn.value;
                console.log("this is submit head button" + btn.value);
                if (getValuesFromInput(first) == '') {
                    first.firstElementChild.nextElementSibling.nextElementSibling.focus();
                    return;
                }
                if (getValuesFromInput(second) == '') {
                    second.firstElementChild.nextElementSibling.nextElementSibling.focus();
                    return;
                }
                if (getValuesFromInput(third) == '') {
                    third.firstElementChild.nextElementSibling.nextElementSibling.focus();
                    return;
                }

                console.log()
                    // sending xml http request to update test title and detais;
                let xml = new XMLHttpRequest();
                xml.onload = function() {
                    let rt = xml.responseText;
                    console.log(rt);
                    rt = Number(rt);
                    if (rt == 1) {
                        console.log(first);
                        console.log(second);
                        console.log(third);
                        console.log(getValuesFromInput(first));
                        console.log(getValuesFromInput(second));
                        console.log(getValuesFromInput(third));

                        first.firstElementChild.nextElementSibling.innerText = first.firstElementChild.nextElementSibling.nextElementSibling.value;
                        first.firstElementChild.nextElementSibling.classList.remove('hidden');
                        first.firstElementChild.nextElementSibling.nextElementSibling.classList.add('hidden');


                        second.firstElementChild.nextElementSibling.innerText = second.firstElementChild.nextElementSibling.nextElementSibling.value;
                        second.firstElementChild.nextElementSibling.classList.remove('hidden');
                        second.firstElementChild.nextElementSibling.nextElementSibling.classList.add('hidden');

                        third.firstElementChild.nextElementSibling.innerText = third.firstElementChild.nextElementSibling.nextElementSibling.value;
                        third.firstElementChild.nextElementSibling.classList.remove('hidden');
                        third.firstElementChild.nextElementSibling.nextElementSibling.classList.add('hidden');

                        btn.previousElementSibling.classList.remove('hidden');
                        btn.classList.add('hidden');

                    }
                }
                xml.open("POST", "UpdateTestTitleAndDetails", "YES");
                // xml.setRequestHeader("ContentType","");
                xml.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xml.send("testId=" + testId + "&testTitle=" + getValuesFromInput(first) + "&testCourse=" + getValuesFromInput(second) + "&testBranch=" + getValuesFromInput(third));
                // *********************************************************






            }

            function getValuesFromInput(btn) {
                let first = btn.firstElementChild.nextElementSibling;
                let second = first.nextElementSibling;
                return second.value;
            }

            function submitTestQuestionsBox(btn) {
                let parent = btn.parentElement.parentElement;
                let first = parent.firstElementChild;
                let second = first.nextElementSibling;
                let third = second.nextElementSibling;
                let fourth = third.nextElementSibling;
                let fifth = fourth.nextElementSibling;
                let sixth = fifth.nextElementSibling;
                let queid = btn.value;

                if (getValuesFromInput(first) == '') {
                    first.firstElementChild.nextElementSibling.nextElementSibling.focus();
                    return;
                }
                if (getValuesFromInput(second) == '') {
                    second.firstElementChild.nextElementSibling.nextElementSibling.focus();
                    return;
                }
                if (getValuesFromInput(third) == '') {
                    third.firstElementChild.nextElementSibling.nextElementSibling.focus();
                    return;
                }
                if (getValuesFromInput(fourth) == '') {
                    fourth.firstElementChild.nextElementSibling.nextElementSibling.focus();
                    return;
                }
                if (getValuesFromInput(fifth) == '') {
                    fifth.firstElementChild.nextElementSibling.nextElementSibling.focus();
                    return;
                }
                if (getValuesFromInput(sixth) == '') {
                    sixth.firstElementChild.nextElementSibling.nextElementSibling.focus();
                    return;
                }

                console.log(getValuesFromInput(first));
                console.log(getValuesFromInput(second));
                console.log(getValuesFromInput(third));
                console.log(getValuesFromInput(fourth));
                console.log(getValuesFromInput(fifth));
                console.log(getValuesFromInput(sixth));
                let xml = new XMLHttpRequest();
                xml.onload = function() {
                    let rt = xml.responseText;
                    console.log(rt);
                    rt = Number(rt);
                    if (rt == 1) {

                        first.firstElementChild.nextElementSibling.innerText = first.firstElementChild.nextElementSibling.nextElementSibling.value;
                        first.firstElementChild.nextElementSibling.classList.remove('hidden');
                        first.firstElementChild.nextElementSibling.nextElementSibling.classList.add('hidden');

                        second.firstElementChild.nextElementSibling.innerText = second.firstElementChild.nextElementSibling.nextElementSibling.value;
                        second.firstElementChild.nextElementSibling.classList.remove('hidden');
                        second.firstElementChild.nextElementSibling.nextElementSibling.classList.add('hidden');

                        third.firstElementChild.nextElementSibling.innerText = third.firstElementChild.nextElementSibling.nextElementSibling.value;
                        third.firstElementChild.nextElementSibling.classList.remove('hidden');
                        third.firstElementChild.nextElementSibling.nextElementSibling.classList.add('hidden');

                        fourth.firstElementChild.nextElementSibling.innerText = fourth.firstElementChild.nextElementSibling.nextElementSibling.value;
                        fourth.firstElementChild.nextElementSibling.classList.remove('hidden');
                        fourth.firstElementChild.nextElementSibling.nextElementSibling.classList.add('hidden');

                        fifth.firstElementChild.nextElementSibling.innerText = fifth.firstElementChild.nextElementSibling.nextElementSibling.value;
                        fifth.firstElementChild.nextElementSibling.classList.remove('hidden');
                        fifth.firstElementChild.nextElementSibling.nextElementSibling.classList.add('hidden');

                        sixth.firstElementChild.nextElementSibling.innerText = sixth.firstElementChild.nextElementSibling.nextElementSibling.value;
                        sixth.firstElementChild.nextElementSibling.classList.remove('hidden');
                        sixth.firstElementChild.nextElementSibling.nextElementSibling.classList.add('hidden');

                        btn.previousElementSibling.classList.remove('hidden');
                        btn.classList.add('hidden');
                    }
                }

                xml.open("POST", "UpdateTestQuestionsAndAnswers", "YES");
                xml.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                // xml.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xml.send("queId=" + queid + "&question=" + getValuesFromInput(first) + "&opt1=" + getValuesFromInput(second) + "&opt2=" + getValuesFromInput(third) + "&opt3=" + getValuesFromInput(fourth) + "&opt4=" + getValuesFromInput(fifth) + "&correctOption=" + getValuesFromInput(sixth));




            }


            function editHead(btn) {
                btn.classList.add('hidden');
                btn.nextElementSibling.classList.remove('hidden');
                let pre = btn.parentElement.parentElement;
                let first = pre.firstElementChild;
                let second = first.nextElementSibling;
                let third = second.nextElementSibling;
                console.log(first);
                editDivs(first);
                console.log(second);
                editDivs(second);
                console.log(third);
                editDivs(third);
            }

            function editDivs(btn) {
                let sec = btn.firstElementChild.nextElementSibling;
                sec.classList.add('hidden');
                sec.nextElementSibling.classList.remove('hidden');
            }

            function editTestQuestionsBox(btn) {
                btn.classList.add('hidden');
                btn.nextElementSibling.classList.remove('hidden');
                let parent = btn.parentElement.parentElement;
                let first = parent.firstElementChild;
                let second = first.nextElementSibling;
                let third = second.nextElementSibling;
                let fourth = third.nextElementSibling;
                let fifth = fourth.nextElementSibling;
                let sixth = fifth.nextElementSibling;
                editDivs(first);
                editDivs(second);
                editDivs(third);
                editDivs(fourth);
                editDivs(fifth);
                editDivs(sixth);
            }




            function addQuestion() {
                let testId = document.getElementById('testId').value;
                let Question = document.getElementById('testQuestionInp').value;
                let option1 = document.getElementById('option1').value;
                let option2 = document.getElementById('option2').value;
                let option3 = document.getElementById('option3').value;
                let option4 = document.getElementById('option4').value;
                let optionSelect = document.getElementById('optionSelect').value;

                if (Question == '' || option1 == '' || option2 == '' || option3 == '' || option4 == '') {
                    showError('Empty field');
                    document.getElementById('testId').parentElement.parentElement.scrollBehavior = 'smooth';
                    document.getElementById('testId').parentElement.parentElement.scroll(0, -200);

                    return;
                }


                let xml = new XMLHttpRequest();
                xml.onload = function() {
                    let rt = xml.responseText;
                    console.log(rt);

                    try {
                        rt = Number(rt);
                    } catch (error) {
                        console.log(error);

                    }
                    if (rt == 1) {
                        succesboxmsg("Questions added successfully ");
                        document.getElementById('testId').parentElement.parentElement.scrollBehavior = 'smooth';
                        document.getElementById('testId').parentElement.parentElement.scroll(0, -200);
                        document.getElementById('testQuestionInp').value = '';
                        document.getElementById('option1').value = '';
                        document.getElementById('option2').value = '';
                        document.getElementById('option3').value = '';
                        document.getElementById('option4').value = '';
                        // document.getElementById('optionSelect').value = '';

                    } else if (rt == 0) {
                        document.getElementById('testId').parentElement.parentElement.scrollBehavior = 'smooth';
                        document.getElementById('testId').parentElement.parentElement.scroll(0, -200);
                        showError("Question already exist ");
                    } else {
                        document.getElementById('testId').parentElement.parentElement.scrollBehavior = 'smooth';
                        document.getElementById('testId').parentElement.parentElement.scroll(0, -200);
                        showError("Question already exist");
                    }
                }
                xml.open('POST', 'AddTestQuestions', 'YES');
                // xml.setRequestHeader("ContentType ", " ")
                xml.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xml.send("testId=" + testId + "&question=" + Question + "&option1=" + option1 + "&option2=" + option2 + "&option3=" + option3 + "&option4=" + option4 + "&correctSelect=" + optionSelect);
            }

            // ***************************************************************************
            // adding add student UI
            function addStudentFormUI() {

                let xml = new XMLHttpRequest();
                xml.onload = function() {
                    console.log(xml.responseText);

                    rightBox.innerHTML = xml.responseText;

                    closeNav();
                }
                xml.open("GET", "AddStudentFormUI", "YES");
                xml.send();
            }

            //*****************************************************************
            //  handling add student part

            document.getElementById('AddStudentForm').addEventListener('submit', (e) => {
                e.preventDefault();
                console.log("default prevented");

            })

            function preventDefaultNature(event) {
                event.preventDefault();
                console.log("default prevented");

            }


            document.getElementById('startInputYear').setAttribute('value', new Date().getFullYear());
            document.getElementById('startInputYear').setAttribute('min', new Date().getFullYear() - 5);
            document.getElementById('startInputYear').setAttribute('max', new Date().getFullYear() + 5);

            function addStudent(btn) {

                let AddStudentForm = document.getElementById('AddStudentForm');
                let form = new FormData(AddStudentForm);


                let v = validateFormObject(form);
                if (v == 0) {
                    return 0;
                }



                if (Array.from(form)[11][1].name == '') {
                    showError("Please select Image");
                    document.getElementById('div').parentElement.style.scrollBehavior = 'smooth';
                    document.getElementById('div').parentElement.scroll(0, -100);
                    return;
                }





                $.ajax({
                    url: "AddStudent",
                    data: form,
                    type: 'POST',
                    success: function(data, textStatus, jqxhr) {
                        console.log(data);
                        let rt = Number(data);

                        if (rt == 1) {
                            succesboxmsg("Student added succefully");
                            AddStudentForm.reset();

                        } else {
                            showError("student not added/duplicate key");
                        }
                        document.getElementById('div').parentElement.style.scrollBehavior = 'smooth';
                        document.getElementById('div').parentElement.scroll(0, -100);
                    },

                    error: function(jqXHR, textStatus, errorThrown) {
                        console.log(data);
                        showError("Student not Added");
                    },
                    processData: false,
                    contentType: false
                })


            }
            //*********************************************************
            function allStudentUI() {
                let xml = new XMLHttpRequest();
                xml.onload = function() {
                    console.log(xml.responseText);
                    rightBox.innerHTML = xml.responseText;
                }
                xml.open("GET", "AllStudentUI", "YES");
                xml.send();
            }
            // here all student part start 



            function showHideFilterBox(a) {
                let filterbox = a.parentElement.parentElement;
                filterbox.classList.toggle('h-10');
                filterbox.classList.toggle('md:h-10');
                filterbox.classList.toggle('h-3/4');
                filterbox.classList.toggle('md:h-1/2');


            }

            function filterForm1(eve, form) {
                eve.preventDefault();
                console.log("defalt preened ");


                form = new FormData(form);

                console.log(form);
                let i = 0;
                let data = '';
                if (Array.from(form)[0][0] == 'SearchValue') {

                    data = data + 'SearchValue=' + Array.from(form)[0][1];

                } else {

                    Array.from(form).forEach(e => {
                        data += e[0] + '=' + e[1] + ((i++) < 3 ? "&" : "");
                    })
                }
                console.log(data);


                let xml = new XMLHttpRequest();
                xml.onload = function() {
                    document.getElementById('studentList').innerHTML = xml.responseText;
                }
                xml.open("POST", "FilterStudent", "YES");
                xml.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                xml.send(data);
            }
            // ********************************************************
            // deleting student 
            function deleteStudent(btn) {
                let sid = btn.value;
                console.log(sid + " edit btn is working");


                let xml = new XMLHttpRequest();
                xml.onload = function() {
                    let rt = xml.responseText
                    try {
                        rt = Number(rt);

                    } catch (error) {
                        console.log(xml.responseText);
                    }

                    if (rt == 1) {
                        btn.parentElement.parentElement.remove();
                    }

                }
                xml.open("GET", "DeleteStudent?ID=" + sid, "YES");
                xml.send();
            }

            //************************************************************* 
            function validateFormObject(form) {

                let flage = 1;
                Array.from(form).forEach(ele => {
                    console.log(ele);
                    if (ele[1] == '') {
                        showError("empty field");
                        document.getElementById('div').parentElement.style.scrollBehavior = 'smooth';
                        document.getElementById('div').parentElement.scroll(0, -100);
                        flage = 0;
                        return 0;

                    }

                });
                return flage == 0 ? 0 : 1;
            }
            // *********************************************************************

            function addUpdateFormUI(btn) {
                console.log(btn.value + " is clicked by edit button");
                let sid = btn.value;
                let xml = new XMLHttpRequest();
                xml.onload = function() {

                    console.log("thsi is onload funfction ");
                    console.log(xml.responseText);
                    rightBox.innerHTML = xml.responseText;
                }
                xml.open("GET", "UpdateStudentFormUI?ID=" + sid, "YES");
                xml.send();
            }

            function updateStudentDetails(e, form) {
                e.preventDefault();
                console.log("default prevented");
                // Array.from(form).forEach(ele => {
                //     console.log(ele);

                // });
                let fr = new FormData(form)
                    // fr.forEach(ele => {
                    //     console.log(ele);

                // })
                $.ajax({
                    url: "UpdateStudent",
                    data: fr,
                    type: 'POST',
                    success: function(data, textStatus, jqxhr) {
                        console.log(data);
                        let rt = Number(data);

                        if (rt == 1) {
                            succesboxmsg("Student Updated succefully");
                            //form.reset();
                            //let inps = form.querySelectorAll('input');
                           

                        } else {
                            showError("student not Updated/duplicate key");
                        }
                        document.getElementById('div').parentElement.style.scrollBehavior = 'smooth';
                        document.getElementById('div').parentElement.scroll(0, -100);
                    },

                    error: function(jqXHR, textStatus, errorThrown) {
                        console.log(data);
                        showError("Student not Added");
                    },
                    processData: false,
                    contentType: false
                })

            }

            // managing notics 
            function showNotices() {
                closeNav();
                let xml = new XMLHttpRequest();
                xml.onload = function() {

                    rightBox.innerHTML = xml.responseText;
                }
                xml.open("GET", "ShowNotices", "YES");
                xml.send();
            }

            function addNoticeForm() {
                console.log("this add notice button");
                let xml = new XMLHttpRequest();
                xml.onload = function() {

                    rightBox.innerHTML = xml.responseText;
                }
                xml.open("GET", "ShowNoticeAddForm", "GET");
                xml.send();

            }

            function addNotice(e, form) {
                e.preventDefault();
                console.log("default prevented");
                // Array.from(form).forEach(ele => {
                //     console.log(ele);

                // });
                let fr = new FormData(form)
                let fr1 = Array.from(fr);
                if (fr1[0][1] == '' || fr1[1][1].name == '') {
                    showError("EmptyField");
                    return;
                }


                $.ajax({
                    url: "AddNotice",
                    data: fr,
                    type: 'POST',
                    success: function(data, textStatus, jqxhr) {


                        console.log(data);
                        let rt = 0;
                        try {
                            rt = Number(data);

                        } catch (error) {
                            console.log(error);

                        }

                        if (rt == 1) {
                            succesboxmsg("Notice Added succefully");
                            form.reset();

                        } else {
                            showError("Notice Not Added Duplicate Title or due to some error ");
                        }

                    },

                    error: function(jqXHR, textStatus, errorThrown) {
                        console.log(data);
                        showError("notice not Added");
                    },
                    processData: false,
                    contentType: false
                });

            }

            function deleteNotice(btn) {
                if (!window.confirm("Are You Sure, You want to delete this Notice?")) {
                    return;
                }
                let noticeId = btn.value;
                let FileName = btn.id;
                console.log(noticeId);
                console.log(FileName);


                let xml = new XMLHttpRequest();
                xml.onload = function() {
                    let rt = xml.responseText;
                    console.log(rt);
                    if (rt == 1) {
                        btn.parentElement.parentElement.remove();
                    }
                }
                xml.open("GET", "DeleteNotice?NoticeId=" + noticeId + "&FileName=" + FileName, "YES");
                xml.setRequestHeader("Content-Type", "application/x-www-from-urlencoded");
                xml.send();

            }
            // *******************************************************
            function visibleAnswers() {

                let xml = new XMLHttpRequest();
                xml.onload = function() {
                    rightBox.innerHTML = xml.responseText;
                }
                xml.open("GET", "VisibleAnswers", "YES");
                xml.send();
            }

            function changeVisibilityto0(btn) {

                let testId = btn.value;
                console.log(testId);
                let xml = new XMLHttpRequest();
                xml.onload = function() {
                    let rt = xml.responseText;
                    rt = Number(rt);
                    if (rt == 1) {
                        let nxt = btn.nextElementSibling;
                        btn.classList.add('hidden');
                        nxt.classList.remove('hidden');
                    } else {
                        console.log(rt);
                    }

                }
                xml.open("GET", "ChangeAnswerSheetStatus?testId=" + testId + "&status=0", "YES");
                xml.send();
            }

            function changeVisibilityto1(btn) {

                let testId = btn.value;
                console.log(testId);
                let xml = new XMLHttpRequest();
                xml.onload = function() {
                    let rt = xml.responseText;
                    rt = Number(rt);
                    if (rt == 1) {
                        let pre = btn.previousElementSibling;
                        btn.classList.add('hidden');
                        pre.classList.remove('hidden');
                    } else {
                        console.log(rt);
                    }

                }
                xml.open("GET", "ChangeAnswerSheetStatus?testId=" + testId + "&status=1", "YES");
                xml.send();
            }

            // *****************************************************************************************

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