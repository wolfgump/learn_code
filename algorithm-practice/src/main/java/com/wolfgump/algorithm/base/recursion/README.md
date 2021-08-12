递归学习：https://medium.com/@daniel.oliver.king/getting-started-with-recursion-f89f57c5b60e

解决递归问题的思考步骤：
- Break the problem I am trying to solve down into a problem that is one step simpler
- Assume that my function will work to solve the simpler problem — really believe it beyond any doubt
- Ask myself: Since I know I can solve the simpler problem, how would I solve the more complex problem?
翻转字符串demo:
 - I am trying to reverse a string. A problem one step simpler would be to reverse a string that is one letter shorter.
 - I will assume, and believe with every fiber of my being, that my function
 - can correctly reverse a string that is one letter shorter than the one I am
  currently trying to reverse.
 - I ask myself: Since I know and believe that my function can correctly reverse a string that is one letter shorter than the one I am currently trying to reverse, how can I reverse the whole string? Well, I can take all of the characters except the first one, reverse those (which I know and believe that my function can do), and then tack the first character on to the end! In code, it would look like this:

常见思想误区：
One common mistake that I see people make when trying to develop a recursive algorithm to solve a problem is that they try to think about how to break the problem down all the way to the base case. I would like to emphasize that in order to develop the function above, I did not think about how I could break the problem down all the way to the base case.