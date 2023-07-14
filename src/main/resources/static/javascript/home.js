//cookie
//const cookieArr = document.cookie.split("=")
//const userId = cookieArr[1];

const baseUrl = 'http://localhost:8080/api/v1/student'

const headers = {
    'Content-Type':'application/json'
}

// Get the form and input elements
const form = document.getElementById('studentForm');
const nameInput = document.getElementById('nameInput');
const emailInput = document.getElementById('emailInput');
const courseSelect = document.getElementById('courseSelect');
const addButton = document.getElementById('addButton');


var courseSize = 0;



const handleSubmit = async (e) => {
    e.preventDefault()
    let bodyObj = {
        studentName: nameInput.value,

        studentEmail: emailInput.value,

        jString: "",

        coursesSet: ""
    }
    await addStudent(bodyObj);
   nameInput.value = ''
   emailInput.value = ''
}

async function addStudent(obj) {
    obj = await addCourseToStudent(obj);
    const response = await fetch(`${baseUrl}/addStudent`, {
    method: "POST", body: JSON.stringify(obj), headers: headers})
    .catch(err => console.error(err.message))
    if(response.status == 200) {
//       return addCourseToStudent(obj);
    }
 }

// display courses

async function displayCourses() {
    await fetch('http://localhost:8080/api/v1/courses', {
    method: "GET", headers: headers})
    .then(res => res.json())
    .then(courses => {
    console.log(courses);
    for(let i = 0; i < courses.length; i++){
        courseSize ++;
        courseSelect.innerHTML += `<option id = "${courses[i].courseId}"> ${courses[i].courseName} </option>`
    }
       })
}

//assigning course to student
async function addCourseToStudent(obj) {

    for(let i = 0; i < courseSelect.options.length; i++){
        console.log(courseSelect.options[i].selected);

        if(courseSelect.options[i].selected) {

            obj.jString += "" + courseSelect.options[i].id + ",";


        }



    }

    obj.jString = obj.jString.substring(0,obj.jString.length -1);

    return obj;
}





addButton.addEventListener("click", handleSubmit);
displayCourses();




//// Populate the course select options from an API endpoint or any other data source
//fetch('http://localhost:8080/api/v1/courses')
//  .then(response => response.json())
//  .then(courses => {
//    courses.forEach(course => {
//      const option = document.createElement('option');
//      option.value = course.id;
//      option.textContent = course.name;
//      courseSelect.appendChild(option);
//    });
//  });
//
//// Event listener for the add button
//addButton.addEventListener('click', event => {
//  event.preventDefault();
//
//  // Get the selected course IDs from the select element
//  const selectedCourseIds = Array.from(courseSelect.selectedOptions, option => option.value);
//
//  // Create the student object
//  const student = {
//    name: nameInput.value,
//    email: emailInput.value,
//    courseIds: selectedCourseIds
//  };
//
//  // Send the student data to the API endpoint for adding a student
//  fetch('http://localhost:8080/api/v1/student/addStudent', {
//    method: 'POST',
//    headers: {
//      'Content-Type': 'application/json'
//    },
//    body: JSON.stringify(student)
//  })
//    .then(response => {
//      if (response.ok) {
//        // Student added successfully
//        console.log('Student added successfully');
//        // Reset the form
//        form.reset();
//      } else {
//        // Handle error response
//        console.error('Failed to add student');
//      }
//    })
//    .catch(error => {
//      // Handle network or other errors
//      console.error('An error occurred:', error);
//    });
//});
//



















//function createStudent(studentData, courseIds) {
//
//const student = {
//    studentId: studentData.studentId,
//    studentName: studentData.studentName,
//    studentEmail: studentData.studentEmail,
//    coursesList: []
//};
//
//courseIds.forEach(courseId => {
//    const course = {
//        courseId: courseId
//    };
//    student.coursesList.push(course);
//
//});
//
//
//// send student object to student table
//
//fetch(`${baseUrl}/addStudent`, {
//    method: 'POST',
//    headers: headers,
//    body: JSON.stringify(student)
//    )
//    .then(response => response.json())
//    .then(data => {
//        console.log('Student created:', data);
//    })
//    .catch(error => console.log(error));
//    }
//
//}




















////dom elements
//const submitForm = document.getElementById('note-form')
//const noteContainer = document.getElementById('note-container')
//
////modal elements
//let noteBody = document.getElementById('note-body')
//let updateNoteBtn = document.getElementById('update-note-button')
//
//const headers = {
//    'Content-Type':'application/json'
//}
//
//
//const baseUrl = 'http://localhost:8080/api/v1/notes/'
//
//function handleLogout() {
//    let c = document.cookie.split(";");
//
//    for(let i in c) {
//    // deletes cookies by setting expiration bast date.. removes by expiring it?
//        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
//    }
//}
//
//const handleSubmit = async (e) => {
//    e.preventDefault()
//    let bodyObj = {
//        body: document.getElementById('note-input').value
//    }
//    await addNote(bodyObj);
//    document.getElementById('note-input').value = ''
//}
//
//async function addNote(obj) {
//    const response = await fetch(`${baseUrl}user/${userId}`, {
//    method: "POST", body: JSON.stringify(obj), headers: headers})
//    .catch(err => console.error(err.message))
//    if(response.status == 200) {
//        return getNotes(userId);
//    }
// }
//
//async function getNotes(userId) {
//    await fetch(`${baseUrl}user/${userId}`, {
//    method:"GET", headers: headers})
//    .then(response => response.json())
//    .then(data => createNoteCards(data))
//    .catch(err => console.error(err))
//}
//
//async function getNoteByID(noteId) {
//    await fetch(`${baseUrl}user/${userId}`, {
//    method: "GET", headers: headers})
//    .then(res => res.json())
//    .then(data => populateModal(data))
//    .catch(err => console.error(err.message))
//}
//
//async function handleNoteEdit(noteId) {
//    let bodyObj = {
//        id: noteId,
//        body: noteBody.value
//    }
//
//    await fetch(baseUrl, {
//    method: "PUT", body: JSON.stringify(bodyObj), headers: headers})
//    .catch(err => console.error(err))
//
//    return getNotes(userId);
//}
//
//async function handleDelete(noteId) {
//    await fetch(baseUrl + noteId, {method: "DELETE", headers: headers})
//    .catch(err => console.error(err))
//    return getNotes(userId);
//}
//
//const createNoteCards = (array) => {
//    noteContainer.innerHTML = ''
//    array.forEach(obj => {
//    let noteCard = document.createElement("div")
//    noteCard.classList.add("m-2")
//    noteCard.innerHTML= `
//        <div class "card d-flex" style ="width: 18rem; height: 18rem;">
//            <div class="card-body d-flex flex-column justify-content- between" style="height: available">
//                <p class="card-text">${obj.body}</p>
//                <div class="d-flex justify-content-between">
//                    <button class="btn btn-danger" onclick="handleDelete(${obj.id})">Delete</button>
//                    <button onclick="getNoteByID(${obj.id})" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#note-edit-modal">Edit</button>
//                </div>
//            </div>
//        </div>
//    `
//    noteContainer.append(noteCard);
//    })
//
//}
//
//const populateModal = (obj) => {
//    noteBody.innerText = ''
//    noteBody.innerText = obj.body
//    updateNoteBtn.setAttribute("data-note-id", obj.id)
//}
//
//getNotes(userId);
//
//submitForm.addEventListener("submit", handleSubmit)
//
//updateNoteBtn.addEventListener("click", (e) => {
//    let noteId = e.target.getAttribute('data-note-id')
//    handleNoteEdit(noteId);
//})
