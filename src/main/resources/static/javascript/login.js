
uservalue = document.getElementById("username")
password = document.getElementById("password")
logbutton = document.getElementById("logbutton")


const headers = {
    'Content-Type':'application/json'
}
const baseUrl = 'http://localhost:8080/api/v1'
const base = `http://localhost:8080`


logbutton.addEventListener("click", async () => {
    let UserId;
    let bodyObj = {
        "username": uservalue.value,
        "password": password.value
    }
    const response = await fetch(`${baseUrl}/users/login`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers

    })
        .catch(err => {
            console.error(err.message)
        })

        .then((response) => {

            if (response.status === 200) {
                alert(` You've Logged In to your account ${uservalue.value}`);

                window.location = `${base}/home.html`;
                document.cookie = `username=${response[2]}`

            } else if (response.status === 500) {
                alert("username or password is incorrect, please try again or register" +
                    "a new account with us, its FREE")
            } else {
                alert("something went wrong hold on, im working on it you can email me and ill try and fix it if you tell me what the problem is ")
            }
            return response.json();
      })
        .then( (res) => {
            document.cookie = `userId=${res[2]}`

        })



})
