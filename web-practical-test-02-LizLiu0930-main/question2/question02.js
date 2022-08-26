window.addEventListener("load", function () {

    // Your code here:

    const body = document.querySelector(".body");


    let list = document.querySelector("ul");
    const firstLi = document.querySelector("li");
    console.log(firstLi);


    for (let i = 0; i < INPUT_JSON.length; i++) {

        let divOfArticle = document.createElement("div");
        divOfArticle.classList.add("article");

        body.appendChild(divOfArticle);
        
        divOfArticle.innerHTML += `
            <h1>${INPUT_JSON[i].title}</h1>
            <h2>By: ${INPUT_JSON[i].author}</h2>
            <h3>Published: ${INPUT_JSON[i].date}</h3>
            <p>${INPUT_JSON[i].body}</p>
        `;


        for (let j = 0; j < INPUT_JSON[i].comments.length; j++) {

            let divOfComment = document.createElement("div");
            divOfComment.classList.add("comment");
            
            divOfArticle.appendChild(divOfComment);
    
            divOfComment.innerHTML += `
                ${INPUT_JSON[i].comments[j].message}<br>
                By: ${INPUT_JSON[i].comments[j].author}
            `;
            
        }


        let liOfTitle = document.createElement("li");
        liOfTitle.innerHTML = `<a href="#">${INPUT_JSON[i].title}</a>`;

        firstLi.appendChild(liOfTitle);
        

    }

    



})