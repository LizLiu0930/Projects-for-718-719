window.addEventListener("load", function () {

    // TODO 1C) Your JS code here

    const card = document.querySelectorAll(".card");

    

    for (let i = 0; i < card.length; i++) {

        const backGroundColor = card[i].getAttribute("backGroundColor");
        // console.log(backGroundColor)

        card[i].addEventListener("click", function(){
            card[i].style.backgroundColor = "dodgerblue";
            for (let j = 0; j < card.length; j++) {
                if (j != i) {
                    card[j].style.backgroundColor = backGroundColor;
                }
            }
        }) 
    }

});