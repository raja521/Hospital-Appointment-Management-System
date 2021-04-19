# Hospital-Appointment-Management-System

The Physiotherapy & Sports Injury Centre (PSIC) is developing a new system to help the booking of 
various treatments it provides. The system stores information on its physiotherapist and patients who 
take treatments. For all members of the PSIC, the centre maintains a unique ID number, full name, 
address, and telephone number. Each physician has one or more areas of expertise, such as 
“Physiotherapy”, “Osteopathy”, “Rehabilitation”. The centre also has a few rooms such as medical 
consulting suites A, B, C, swimming pool and gym (for rehabilitation session).
Physicians offer treatments in their areas of expertise: these treatments will be named (for example 
“Neural mobilisation”, “Acupuncture”, “Massage”, “Mobilisation of the spine and joints”, “Pool 
rehabilitation”). The appointment will be booked at a specified date/time period (e.g. “Saturday 1st May
2021,10:00-12:00), and take place in a room (e.g. medical consulting suite A). An appointment can be 
changed (i.e., cancelling it and booking a new appointment) or cancelled before it takes place. An 
appointment is attended when a patient has been checked in.
Implement a way for patients to look up and book treatment appointments with various physicians. A 
patient can look up an area of expertise, see a list of available physicians and the available treatments 
they offer including the time and room, and then book the appointment they choose. For example, there 
may have two physicians who offer Massage at different times. A patient may also directly look up a 
physician by their name to find all the available treatments offered including the time and room. 
Therefore, your system should provide two ways for looking up the available treatments.
Visitors often come to the centre for initial consultation. Allow them to look up a physician by either 
expertise or name. Each physician will have 2 consultation hours each week (e.g., 2 hours on Monday 
afternoon). Visitors can be given an appointment to see the physician within a 30-minutes time slot they 
choose. Visitors do not need to be registered with the system but their names can be recorded as notes 
to each consultation appointment. Patients (not visitors) cannot book an appointment with one physician 
during his/her consultation hours.
For simplicity, design your system for a single term of 4 weeks (within a month). There are both patient 
appointments and visitor consultation appointments within these 4 weeks. At the end of the term, the 
centre produces a report listing all treatment appointments (physician name, treatment name, patient 
name, time, room) and visitor appointments (physician name, time, notes containing visitor name). Also, 
another report will be produced to list all treatment appointments each patient has booked, attended, 
cancelled, and missed.
In your final deliverable, have the program set up some physicians, patients, and 4-week timetable of the 
treatments offered by each physician. One physician may just work one or two days each week. Provide 
data covering at least 5 physicians and 15 patients, which can then be displayed and used for testing. 
These pre-registered data can be hard coded in your program or read from external files. The system 
should also allow new patients to be registered and then book the appointments. Visitors use the system 
to book consultation appointments but don’t need to be registered.