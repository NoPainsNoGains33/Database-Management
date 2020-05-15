const studentModel = require('../models/students/student.model.server')

createStudent = student => studentModel.create(student)

deleteStudent = studentId => studentModel.deleteOne({_id: studentId})

deleteAllStudents = () => studentModel.remove({})

findAllStudents = () => studentModel.find()

findStudentById = studentId => studentModel.findOne({_id: studentId})

updateStudent = (studentId, student) => studentModel.update({_id: studentId}, {$set: student})

module.exports = {
    createStudent,
    deleteStudent,
    deleteAllStudents,
    findAllStudents,
    findStudentById,
    updateStudent
}