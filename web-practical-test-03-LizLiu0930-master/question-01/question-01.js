// Setup Express
const express = require("express");
const app = express();
const port = 3000;

// Setup Handlebars
const handlebars = require("express-handlebars");
app.engine("handlebars", handlebars({
    defaultLayout: "main"
}));

app.set("view engine", "handlebars");

// Setup body-parser
const bodyParser = require("body-parser");
app.use(bodyParser.urlencoded({ extended: false}));

// Make the "public" folder available statically
const path = require("path");
app.use(express.static(path.join(__dirname, "public")));

// When navigating to "/", render home.handlebars
app.get("/", function(req, res) {
    res.render("home");
});


// YOU CAN CREATE YOU HANDLER FUNCTION HERE
app.post("/surveyData", function(req, res) {

    const timeOfWriting = parseFloat(req.body.writing);
    const timeOfDebugging = parseFloat(req.body.debugging);
    const timeOfStackoverflow = parseFloat(req.body.stackoverflow);

    const totalTime = timeOfWriting + timeOfDebugging + timeOfStackoverflow;
    
    const Writing = timeOfWriting / totalTime * 100;
    const Debugging = timeOfDebugging / totalTime * 100;
    const Stackoverflow = timeOfStackoverflow / totalTime * 100;

    let developerArray = {}; 

    developerArray = {
        developer : req.body.name,
        favouriteLanguages : req.body.languages,
        mostInterest : req.body.interest,
        time : {
            Writing,
            Debugging,
            Stackoverflow
        },
        goals :req.body.goals,
        goalsTime : req.body.goalsTime

    }
    // const developerName = req.body.name;
    // res.locals.developer = developerName;

    // const favouriteLanguages = req.body.languages;
    // res.locals.languages = favouriteLanguages;

    // const mostInterest = req.body.interest;
    // res.locals.mostInterest;

    // const timeOfWriting = req.body.writing;
    // res.locals.timeOfDebugging;
    // const timeOfDebugging = req.body.debugging;
    // res.locals.timeOfDebugging;
    // const timeOfStackoverflow = req.body.stackoverflow;
    // res.locals.timeOfStackoverflow;

    // const goals = req.body.goals;
    // res.locals.goals;
    // const goalsTime = req.body.goalsTime;
    // res.locals.goalsTime;

    // console.log(developerArray);
    res.locals.developerData = developerArray;

    res.render("survey");

})



// Start the server running. Once the server is running, the given function will be called, which will
// log a simple message to the server console. Any console.log() statements in your node.js code
// can be seen in the terminal window used to run the server.
app.listen(port, function() {
    console.log(`Example app listening on port ${port}!`);
});