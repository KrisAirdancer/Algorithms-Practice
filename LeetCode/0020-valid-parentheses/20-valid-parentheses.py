class Solution:
    def isValid(self, s: str) -> bool:
        openParens = []

        for i in range(len(s)):
            if s[i] == '(' or s[i] == '{' or s[i] == '[':
                openParens.append(s[i])
            else:
                if len(openParens) <= 0:
                    return False
                openParen = openParens.pop()

                if openParen == '(' and s[i] != ')':
                    return False
                if openParen == '{' and s[i] != '}':
                    return False
                if openParen == '[' and s[i] != ']':
                    return False
        return len(openParens) == 0


# ***** IDEA *****
# Push open parentheses to a stack. When an closed parentheses is encountered, pop the stack. If the open parenteheses that was popped is the same type as the closed one, continue; otherwise, return false.
# > Each time a parentheses is popped, we will need to check what kind it is so we can check the type of the curernt one correctly.
# ***** OUTLINE *****
# Instantiate a stack: "openParentheses"
# Loop: For i in str,
#     If open parentheses, - (, {, or [ - push it to the stack.
#     If closed parentheses,
#         If stack.size == 0, return False
#         Pop stack and store result: "open"
#         If open == ( and s[i] != ),
#             Return False
#         If open == { and s[i] != },
#             Return False
#         If open == [ and s[i] != ],
#             Return False
# If stack.size != 0, return False
# Return True
# **** NOTES *****
# > Can use list.append() and list.pop() as a stack in Python.