const baseUrl = `http://localhost:8080/api/v1`
const base = `http://localhost:8080`

Amount = 0
let DisableAddingNotes = false;
let UserCount = 0

const removingBoxes = () => {
    let allBoxes = document.querySelectorAll('.anotherbox');
    allBoxes.forEach(box => {
        box.remove();
    });
}
const DeleteNoteFromDatabase = async (noteId) => {
    const headers = {
        'Content-Type':'application/json'
    }
    const response = await fetch(`${baseUrl}/notes/${noteId}`, {
        method: "DELETE",
        headers: headers
    })
        .catch((err) => {console.log(err)})
        .then( (res) => {
            console.log("Note Removed")
        })
}
const addingANote = (noteBody , num) => {
    let div = document.createElement("div")
    div.innerHTML = `<div class="anotherbox" id = "EmptyBoxForNote${num}">
  <div class="card shadow-sm" id = BoxWords>
    <div class="card-body">
      <p class="card-text" id = "Notes">${noteBody} </p>
      <div class="d-flex justify-content-between align-items-center">
        <div class="btn-group">
          <button type="button" id= "PlayButtonForNote${num}"class="btn btn-sm btn-outline-success">Run Block</button>
          <button type="button" id = "EditButtonForNote${num}"class="btn btn-sm btn-outline-secondary">Edit</button>
        </div>
        <button type="button" id = "TrashButtonForNote${num}" class="btn btn-sm btn-outline-danger">Delete</button>
      </div>
    </div>
  </div>
</div>`
    document.getElementById('CodeBoxesContainer').appendChild(div)

    let ThisNote = document.getElementById(`EmptyBoxForNote${num}`)
    let ThisTrashButton = document.getElementById(`TrashButtonForNote${num}`)
    let ThisEditButton = document.getElementById(`EditButtonForNote${num}`)
    let ThisPlayButton = document.getElementById(`PlayButtonForNote${num}`)
   ThisTrashButton.addEventListener('click' , () => {
       confirm('This Will delete Your Note Are You Sure?')
       ThisNote.remove()
       DeleteNoteFromDatabase(num)
   })
    ThisEditButton.addEventListener('click' , () => {
        ThisNote.remove()
        DeleteNoteFromDatabase(num)
        ShowingTheBox("Show",num ,noteBody)

    })
    ThisPlayButton.addEventListener('click', () => {

        new Function(noteBody)();
    })


}


const userIdCookie = document.cookie.split('; ')
    .find(row => row.startsWith('userId='))
    ?.split('=')[1];
if(userIdCookie == "undefined"){
   window.location = `${base}/login.html`
}

const GettingUserNotes = async () => {

    const headers = {
        'Content-Type':'application/json'
    }
    const response = await fetch(`${baseUrl}/notes/user/${userIdCookie}`, {
        method: "GET",
        headers: headers
    })
        .catch(err => {
            console.error(err.message)
        })
        .then((response) => {
            return response.json();
        })
        .then((res) => {
            //res is all the notes not split proprely or nothing so lets do this
            if(res.length > 0){
                for(let x = 0; x < res.length;x++){
                        let unSplitNoteBody = res[x].split(';AzariSplitter987ef3swilos83r1s3l0s87je7c7c7gc7c7gc7cg');
                        let NoteBody = unSplitNoteBody[0]
                        let NoteId = unSplitNoteBody[1]




                             if(NoteBody.length > 10000000){
                            let ShorterBody = NoteBody.slice(0 , 90)
                            addingANote(ShorterBody , NoteId)

                        }
                        else {
                            addingANote(NoteBody, NoteId)
                            // console.log(NoteBody)
                        }




                }
            }
        })
};
const AddingServerNote = async (body) => {
    let allBoxes = document.querySelectorAll('.anotherbox');
    if(allBoxes.length >= 5){
        alert('You Have Too Many Notes Do Note Try To Add More');
            return;

            }
    let bodyObj = {
        "body": body
    }

    const headers = {
        'Content-Type':'application/json'
    }
    const response = await fetch(`${baseUrl}/notes/user/${userIdCookie}`, {
        method: "POST",
        headers: headers,
        body:  JSON.stringify(bodyObj)
    })
        .catch(err => console.log(err))

    removingBoxes();
    GettingUserNotes();
}
// GettingUserNotes();
let addNoteButton = document.getElementById('AddNotesButton')





const ShowingTheBox = (ShowOrNoShow, body) => {
    let BackGround = document.getElementById('background')
    let CodeBox = document.getElementById('BigMidBox')
    let TextBox = document.getElementById('TextArea')

    if (body === undefined){}
    else{TextBox.value = body}

 if(ShowOrNoShow === "Show") {

     let allBoxes = document.querySelectorAll('.anotherbox');
     if(allBoxes.length >= 5){
         alert('You Have Too Many Notes Do Note Try To Add More');
         return;

     }
     TextBox.style.visibility = "visible"
     CodeBox.style.visibility = "visible"
     BackGround.style.visibility = "visible"
     BackGround.addEventListener('click', () => {
         ShowingTheBox("Hide")

     })
 }else {
     TextBox.style.visibility = "collapse"
     CodeBox.style.visibility = "collapse"
     BackGround.style.visibility = "collapse"
     let Body = TextBox.value

     AddingServerNote(Body)

     return;

 }
}



addNoteButton.addEventListener('click', () => {ShowingTheBox("Show")})
GettingUserNotes();




