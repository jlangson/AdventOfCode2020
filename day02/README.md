there are two numbers which tell you information about if a password is valid
in ruleone there can be between (inclusive) that many occurences
in ruletwo there must be the correct character at ONE of those locations

could be improved by refactoring to use better field names that encompass both ruleOne and ruleTwo's meaning. field names reflect the meaning in ruleOne

## Rule One
// 1-3 a: abcde //should have 1 to 3 'a' VALID
// 1-3 b: cdefg //should ahve 1 to 3 'b' INVALID
// 2-9 c: ccccccccc //should have 2 to 9 'c' VALID


## Rule Two
// Each policy actually describes two positions in the password, 
//where 1 means the first character, 2 means the second character,
// and so on. (Be careful; Toboggan Corporate Policies have no concept of "index zero"!) 
//Exactly one of these positions must contain the given letter. Other occurrences of the letter are irrelevant for the purposes of policy enforcement.

// Given the same example list from above:

// 1-3 a: abcde is valid: position 1 contains a and position 3 does not.
// 1-3 b: cdefg is invalid: neither position 1 nor position 3 contains b.
// 2-9 c: ccccccccc is invalid: both position 2 and position 9 contain c.
