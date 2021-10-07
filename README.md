# Online Private Tutors Finder System

![UML diagram of the code](tutors-finder-system.png)


### The task:
This private tutor system will help to find tuition teachers
from nearby locations. Teachers can also get a student
just by logging onto the website and setting up the profile.
In the personal tutor finder system, there are three
entities namely, Admin, Parents, and Tutor. Admin can
login, manage tutor by adding new teachers and update
their profiles. Admin can also manage E-books by adding
new books to the library. Admin can also check for the
registered parents. Admin will register tutors and
credentials will be shared with tutors by Email. Parents
can register and login, tutors can be viewed by parents.
Parents can filter and select the tutor and after selecting
parents will raise the request of the demo lecture. After
attending the lecture, they can book the tutor online, rate
the tutor and view the E-Books. The tutor can login by
using credentials that will be provided by mail. They can
check for the request for a demo lecture and accept the
request. They can also check the booking done. They
need to set their profile. This private tuition system can
help the tutors to get students and parents to find the best
tutors for their children.

## Report
Our team implemented Tutors Finding System to help find tuition teachers from nearby locations. The system has users such as Tutor, Parent, and Admin which are derived from User superclass. Each type of user has its specific functionality. For example, Parent can filter tutors by ``filter(...)``.

To operate with the pool of users and other objects, it was suggested to create class "DataBase" which will provide an interface for interacting with pools of objects. One of the responsibilities of DataBase is to register users which is done by User ``register(...)``.

For both filtering tutors and registering users, it was decided to use fabric methods. The reason is that it provides a convenient way to extend internals if, for example, we decide to add a new type of filter or a new type of user. ``register(...)`` method, based on the arguments, creates and returns the corresponding user type. Similarly, createFilter(...) creates and returns a Filter class with specified filter criteria which will be used by ``filter(...)``. It is most likely, that there will be demand for new filters, so it can be easily done by adding a filter to the ``createFilter(...)``.

Overall, the system provides functionality for registering users(``register``), booking(``bookTutor``), rating(``rateTutor``), finding and filtering tutors(``filter``), and other functionality needed.
