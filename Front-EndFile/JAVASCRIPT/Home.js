


const headers = {
    'Content-Type':'application/json'
}
const baseUrl = 'http://localhost:8080/api/v1'

let fakecode = 
`01234567891011121314151617
1181920212223242526272829
30313233343536373839404142`
// code cant have more length than
//25 characters per line 
//only allowed 3 lines per sheet 

console.log(fakecode[21])
// const addingNote = (noteBody) => {
//    let div = document.createElement("div")
//     div.innerHTML = ` <div id = "emptybox"  class = "anotherbox">
       
//     <div id = "BoxWords">
//        <div id = "Notes" class = "Notes"> 
//     ${noteBody}
      
//       </div></div>
//       <div class = "TrashButton" id = "TrashButton">Trash</div>
//       <div class="EditButton" id = "EditButton">Edit Code</div>
//       <div class="PlayButton" id = "PlayButton">Secret</div>
// </div>`;

// document.getElementById('NOTEBOXS').appendChild(div)
// }



const AddingABetterNote = (noteBody) => {
let div = document.createElement("div")
div.innerHTML = 
`<div class="col row anotherbox" id = "emptyBox">
  <div class="card shadow-sm" id = BoxWords>
    <div class="card-body">
      <p class="card-text" id = "Notes">${noteBody} </p>
      <div class="d-flex justify-content-between align-items-center">
        <div class="btn-group">
          <button type="button" id= "PlayButton"class="btn btn-sm btn-outline-success">Run Block</button>
          <button type="button" id = "EditButton"class="btn btn-sm btn-outline-secondary">Edit</button>
        </div>
        <button type="button" id = "TrashButton" class="btn btn-sm btn-outline-danger">Delete</button>
      </div>
    </div>
  </div>
</div>`
    document.getElementById('CodeBoxesContainer').appendChild(div)
    
}


for(let i = 0; i < 3;i++){
    AddingABetterNote(fakecode)
}
const Back = document.getElementById('BackgroundColor')


Box = document.body
let addNoteButton = document.getElementById('AddNotesButton')

function ShowingAnCodeEditor(body) {   
     alert('This Will pull up the text editer input box') 
document.getElementById('CodeBox').style.visibility = "visible"
const CodeBox = document.getElementById('CodeBox')
const CodeText = document.getElementById(`CodingInputBox`)
if(body === undefined){CodeText.value = ''}
else{CodeText.value = body}

CodeBox.style.visibility = "visible"
CodeBox.style.opacity = 1;
Back.style.zIndex = 5
CodeBox.style.zIndex = 6
SaveButton = document.getElementById('SaveButton')
SaveButton.style.zIndex = 7
const endingTheBox = () => {
Back.style.zIndex = -1
CodeBox.style.visibility = "collapse"
Back.style.visibility = "collaspse"
console.log('Saved')
BodyValue = CodeText.value
} 
Back.addEventListener('click', () => {
endingTheBox()
})
SaveButton.addEventListener('click', () => {
endingTheBox()            
})}
addNoteButton.addEventListener('click', () => 
{
    ShowingAnCodeEditor('for(let x = 0;x < 10;x++){console.log("lol")}') 
})
