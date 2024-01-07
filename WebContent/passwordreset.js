let errorbox = document.getElementById('errorbox');
let oldPassword = document.getElementById('oldPassword');
let newPassword = document.getElementById('newPassword');
let confirmPassword = document.getElementById('confirmPassword');
let submit = document.getElementById('submit');
submit.addEventListener('click', () => {
    console.log('submit button');
    if (oldPassword.value == '' || newPassword.value == '' || confirmPassword.value == '') {
        showError('empty field');
        return;
    }
    let xml = new XMLHttpRequest();

    xml.onload = function() {
        let ot = xml.responseText;
        try {
            ot = Number(ot);

        } catch (error) {
            console.log(error);
            showError('password not changed');
            return;

        }

        if (ot == 1) {
            showSuccessMsg("Password changed successfully");
        } else if (ot == 0) {
            showError("old password is wrong");
        } else {
            showError('password not changed');
        }
    }
    xml.open('GET', 'ChangePassword?utype=student&oldPassword=' + oldPassword + '&newPassword=' + newPassword, 'yes');
    xml.send();




})


function showError(msg) {
    errorbox.classList.remove('hidden');
    errorbox.innerText = msg;
    setTimeout(() => {
        errorbox.classList.add('hidden');
    }, 2000);

}

function succesboxmsg(msg) {
    let succesboxmsg = document.getElementById('succesboxmsg');
    succesboxmsg.classList.remove('hidden');
    errorbox.innerText = msg;
    setTimeout(() => {
        succesboxmsg.classList.add('hidden');
    }, 3000);
}
newPassword.addEventListener('input', () => {
    let cp = confirmPassword.value;
    let np = newPassword.value;


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

})



confirmPassword.addEventListener('input', () => {
    let cp = confirmPassword.value;
    let np = newPassword.value;


    console.log(np.substr(0, 3));

    if (np.substr(0, cp.length) != cp) {
        showError('confirom and new password not matches');
        submit.disabled = true;
        submit.classList.add('disabled-button');
    } else {
        submit.disabled = false;
        submit.classList.remove('disabled-button');
    }

})