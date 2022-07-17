



uservalue = document.getElementById("username")
password = document.getElementById("password")
Register = document.getElementById("Register")



const headers = {
    'Content-Type':'application/json'
}




// const base = process.env.PORT || `http://localhost:8080`;
const base = `https://codingjournal.herokuapp.com`
const baseUrl = `${base}/api/v1`

Register.addEventListener("click" ,async () => {
        let bodyObj = {
            "username":uservalue.value ,
            "password":password.value

        }



    const response = await fetch(`${baseUrl}/users/register`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers

    })

        .catch(err => {
                const newthing = err


                console.error(err.message)
            console.log(newthing)
            }
        )

        const responseArr = await  response.json()

        if(response.status === 200){

        alert(" You've Succsefully Registered The Account  ")
            window.location = `${base}/login.html`;
    }
        else if(response.status === 500){alert("So sorry but the username is taken")}
        else{alert("something went wrong hold on, im working on it ")}

})
