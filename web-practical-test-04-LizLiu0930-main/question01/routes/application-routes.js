const express = require("express");
const router = express.Router();

const animalsDao = require("../modules/animals-dao.js");

// Whenever we navigate to /, render the home view.
router.get("/", async function(req, res) {
    
    res.render("home");
});


router.post("/animalByName", async function(req, res) {
    const animalName = req.body.name;
    const messages = await animalsDao.getAnimalByName(animalName);
    res.locals.messages = messages;
    res.render("animalByName");
});


router.post("/animalByCountryAndPrice", async function(req, res) {
    const country = req.body.country;
    const maxPrice = req.body.maximumPrice;
    const animalFrom = await animalsDao.animalByCountry(country);
    
    if (animalFrom){
        const meassages = await animalsDao.animalByMaxPrice(maxPrice);
    }
    res.locals.meassages = meassages;
    res.render("animalByCountryAndPrice");
});



router.post("/animalBy3CountryAndPrice", async function(req, res) {
    const country_1 = req.body.country_1;
    const country_2 = req.body.country_2;
    const country_3 = req.body.country_3;

    const maxPrice = req.body.maxiPrice_2;
    const animalFrom = await animalsDao.animalByCountry(country_1);
    
    if (animalFrom){
        const meassages = await animalsDao.animalByMaxPrice(maxPrice);
    }
    res.locals.meassages = meassages;
    res.render("animalBy3CountryAndPrice");
});








module.exports = router;