# Family Tree

Meet The Family
Write code to model out the King Shan family tree so that:
• Given a ‘name’ and a ‘relationship’, you should output the people corresponding to the relationship in the order in
which they were added to the family tree. Assume the names of the family members are unique.
• You should be able to add a child to any family in the tree through the mother.
Simple, right? But remember.. our evaluation is based not only on getting the right output, but on how you've written your code.
Relationships To Handle
There are many relations that could exist but at a minimum, your code needs to handle these relationships.
Relationships Paternal-Uncle Maternal-Uncle Paternal-Aunt Maternal-Aunt Sister-In-Law Brother-In-Law Son Daughter Siblings
Definition Father’s brothers Mother’s brothers Father’s sisters Mother’s sisters
Spouse’s sisters,
 Wives of siblings
Spouse’s
brothers,
 Husbands of
siblings 
© 2020 geektrust. All rights reserved.
Sample Input/Output
ADD_CHILD ”Mother’s-Name" "Child's-Name"
"Gender"
GET_RELATIONSHIP ”Name” “Relationship”
Do initialise the existing family tree on program start. Your program should take the location to the
test file as parameter. Input needs to be read from a text file, and output should be printed to the
console. The test file will contain only commands to modify or verify the family tree.
ADD_CHILD Chitra Aria Female
GET_RELATIONSHIP Lavnya Maternal-Aunt
GET_RELATIONSHIP Aria Siblings
CHILD_ADDITION_SUCCEEDED
Aria
Jnki Ahit
Input format to add a child:
Input format to find the people belonging to a relationship:
Example test file:
”Name 1” “Name 2”… “Name N”
Output format on finding the relationship:
Output on finding the relationship:
© 2020 geektrust. All rights reserved.
More sample input output scenarios.
Please stick to the Sample input output format as shown. This is very important as we are automating the
correctness of the solution to give you a faster evaluation. You can find some sample input output files here. 

Run command: java -jar FamilyTree/target/FamilyTree.jar <Path_to_the_input_file> <br>
Example: java -jar FamilyTree/target/FamilyTree.jar FamilyTree/input-file.txt <br>
