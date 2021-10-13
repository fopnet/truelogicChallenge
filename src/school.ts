// Description:

// Create a School class
// 1. it should have a dataSource (it serves as an object that will store the grades and its students)
// 2. also it should have two methods:
// addStudent(name, grade)
// and
// getSortedRoster() which returns the roster of grades and each grade with its students

// NOTE: all our students only have one name.
// NOTE: avoid using `any`

// HINT: it is helpful to use a Map as the dataSource!

class School {
    private ds: { [key: number]: string[]; } = { };

    addStudent(name:string, grade:number) {
        grade = grade || 0; // not required in requirement
        this.ds[grade] = this.ds[grade] || [];
        
        this.ds[grade].push(name);
    }

    getSortedRoster() {
     return Object.keys(this.ds).sort()
                    .reduce((r, k) => (r.push( { grade: Number(k), students: this.ds[k].sort() } ) , r), []);
    }
}

// creating object to test the class functionality
const school = new School();

school.addStudent("tom", 2); school.addStudent("ian", 2);
school.addStudent("fred", 2); school.addStudent("alice", 1);
school.addStudent("victor", 1); school.addStudent("chris", 3);
school.addStudent("kim", 3); school.addStudent("sam", 3);
school.addStudent("felipe", undefined); school.addStudent("pina", null);

var roster = school.getSortedRoster();

console.log("resultado\n", roster);


// expected roster:
/*
 * [ 
     { grade: 1, students: ['alice', 'victor'] }, 
     { grade: 2, students: ['fred', 'ian', 'tom'] }, 
     { grade: 3, students: ['chris', 'kim', 'sam'] } 
    ]
 */
