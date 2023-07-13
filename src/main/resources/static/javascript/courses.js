// put elements here once created in HTML

//DOM Elements

const submitForm = document.getElementById("course-form")
const tableHeading = document.getElementById("courses-table-heading")
const courseContainer = document.getElementById("courses-container")
const submitButtion = document.getElementById("submit-button")

//Modal Elements



const headers = {
    'Content-Type':'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/courses/'

// form submission & creating rows for course information

const handleSubmit = async (e) => {
    e.preventDefault()

    let bodyObj = {
        name: document.getElementById("course-name-input").value,
        description: document.getElementById("course-description-input").value,
        credits: document.getElementById("course-credits-input").value
        }

        const response = await addCourse(bodyObj);
        document.getElementById("course-name-input").value = ""
        document.getElementById("course-description-input").value = ""
        document.getElementById("course-credits-input").value = ""

        if(response) {
            const {id, name, description, credits} = response;

            const courseRow = document.createElement("tr");
            courseRow.innerHTML = `
                        <td>${credits}</td>
                        <td>${name}</td>
                        <td>${description}</td>
                        <td> <button class="btn btn-danger" onclick="handleDelete(${id})">Delete</button></td>`;

                    courseContainer.appendChild(courseRow);
        }


}


// Adding a course
//async function addCourse(obj) {
//    try{
//    const response = await fetch(`${baseUrl}/courses/addCourse`,  {
//        method: 'POST',
//        body: JSON.stringify(obj),
//        headers: headers
//       });
//       if(response.status === 200) {
//          return response.json();
//          }
//        }
//      catch(err => console.error(err.message))
//    }

// Adding a course
async function addCourse(obj) {
  try {
    const response = await fetch(`${baseUrl}addCourse`, {
      method: 'POST',
      body: JSON.stringify(obj),
      headers: headers
    });

    if (response.status === 200) {
      return response.json();
    }
  } catch (err) {
    console.error(err.message);
  }
}




// deleting a course (will be called in the modal elements)

async function deleteCourse(courseId) {
    await fetch(`${baseUrl}/courses/${courseId}`, {
      method: 'DELETE',
      headers: headers
    }).catch(err => console.log(err))

    return //get courses?;
  }


/// submitting the form

submitForm.addEventListener("submit", handleSubmit)
