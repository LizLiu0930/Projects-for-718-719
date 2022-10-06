const SQL = require("sql-template-strings");
const dbPromise = require("./database.js");

async function getAnimalByName(name) {  
    const db = await dbPromise;
    const messages = await db.all(SQL`
        select * from ANIMAL_DATA a
        where a.animal_name = ${name};
    `);
    return messages;
}


async function animalByCountry(country) {  
    const db = await dbPromise;
    const messages = await db.get(SQL`
        select * from ANIMAL_DATA a
        where a.country = ${country};
    `);
    return messages;
}


async function animalByMaxPrice(maxPrice) {  
    const db = await dbPromise;
    const messages = await db.get(SQL`
        select * from ANIMAL_DATA a
        where a.maxPrice <= ${maxPrice};
    `);
    return messages;
}





// Export functions.
module.exports = {
    getAnimalByName,
    animalByCountry,
    animalByMaxPrice
};
