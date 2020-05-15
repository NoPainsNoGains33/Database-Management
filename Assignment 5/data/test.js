const mongoose = require ('mongoose');
mongoose.connect('mongodb://localhost:27017/mongoose');

const universityDao = require ('./daos/university.dao.server')

universityDao.truncateDatabase()
    .then(() =>
        universityDao.populateDatabase()
    )
    .then( () =>
        universityDao.testStudentsInitialCount()
    )
    .then(() =>
        universityDao.testQuestionsInitialCount()
    )
    .then(() =>
        universityDao.testAnswersInitialCount()
    )
    .then(() =>
        universityDao.testDeleteAnswer()
    )
    .then(() =>
        universityDao.testDeleteQuestion()
    )
    .then(() =>
        universityDao.testDeleteStudent()
    )


// If there is a fuction and you need to write a .then ()
// There must be a return! No matter () => {} or funciton () {}
// It is different with () => ...
// universityDao.truncateDatabase()
//     .then( function () {
//         return universityDao.populateDatabase()
//     })
//     .then(function () {
//         return universityDao.testStudentsInitialCount()
//     })
//     .then(function () {
//             return universityDao.testQuestionsInitialCount()
//         })




