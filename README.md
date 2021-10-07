# Online Private Tutors Finder System

![UML diagram of the code](tutors-finder-system.png)

## Report
Our team implemented Tutors Finding System to help find tuition teachers from nearby locations. The system has users such as Tutor, Parent, and Admin which are derived from User superclass. Each type of user has its specific functionality. For example, Parent can filter tutors by ``filter(...)``.

To operate with the pool of users and other objects, it was suggested to create class "DataBase" which will provide an interface for interacting with pools of objects. One of the responsibilities of DataBase is to register users which is done by User ``register(...)``.

For both filtering tutors and registering users, it was decided to use fabric methods. The reason is that it provides a convenient way to extend internals if, for example, we decide to add a new type of filter or a new type of user. ``register(...)`` method, based on the arguments, creates and returns the corresponding user type. Similarly, createFilter(...) creates and returns a Filter class with specified filter criteria which will be used by ``filter(...)``. It is most likely, that there will be demand for new filters, so it can be easily done by adding a filter to the ``createFilter(...)``.

Overall, the system provides functionality for registering users(``register``), booking(``bookTutor``), rating(``rateTutor``), finding and filtering tutors(``filter``), and other functionality needed.
