class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        operands = []

        for token in tokens:
            if self.isOperand(token):
                rightOp = operands.pop()
                leftOp = operands.pop()

                if token == "+":
                    operands.append(leftOp + rightOp)
                elif token == "-":
                    operands.append(leftOp - rightOp)
                elif token == "*":
                    operands.append(leftOp * rightOp)
                elif token == "/":
                    operands.append(int(leftOp / rightOp))
            else:
                operands.append(int(token))

        return operands.pop()

    def isOperand(self, token: str) -> bool:
        if token == "+" or token == "-" or token == "*" or token == "/":
            return True
        else:
            return False

# ***** INPUTS *****
# > A list (array) of strings. Each string represents either an operator or an operand (number).
# >> This input array represents a Reverse Polish Notation expression that we are to evaluate.
# >> Input array will not include any decimal values - it only includes integers.
# ***** OUTPUTS *****
# > A single integer representing the result of the given RPN expression.
# ***** EDGE CASES *****
# > Don't have to handle division by zero.
# > Must truncate TOWARDS zero. Ex. -3/2 = -1.5 must round to -1, not to -2; and 3/2 =1.5 must round to 1, not to 2.
# > Inputs are guaranteed to be valid RPN expressions.
# ***** IDEAS *****
# Push the tokens in the input array to the stack.
# > Push operands, but not operators.
# When an operand is reached, pop the most recent two numbers and apply the operator to them.
# > The first number off of the stack is the right operand. The second number off the stack is the left operand.
# Push the result to the stack.
# Continue until no tokens are left in the input list.
# Return the only element on the stack.
# ***** NOTES *****
# > To check if a token is an operator or operand, all I need to do is check if the token is an operand. If it isn't, it must be an operator.
# >> Note that there is no need to check for any non-integer values b/c we are guarantted a valid RPN expression which only contains numbers and operands.
# ***** PSEUDO CODE *****
# Create a stack
# Loop over input array,
#     Get current token
#     If current token is an operator, (can check for this with a simple string comparison)
#         Pop two items from the stack
#         Apply the operand to them (first number off is right operand in expression)
#         Push result to stack
#     If current token is a number,
#         Push to stack
# Return the top of the stack (there should be only a single item left on the stack)
# ***** PERFORMANCE *****
# Time Complexity: O(N) - Only need to loop over the input array once to evaluate the expression.
# Memory Complexity: O(N) - O(N) - May need to store up to ~1/2 N items on the stack (Ex. 5 operands and 4 operators) plus the input array, so ~O(1.5N) which rounds to O(N).