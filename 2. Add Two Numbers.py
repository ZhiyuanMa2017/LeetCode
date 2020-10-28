def addTwoNumbers(self, l1, l2):
    """
    :type l1: ListNode
    :type l2: ListNode
    :rtype: ListNode
    """
    num1=0
    num2=0
    length1 = len(l1)
    length2 = len(l2)
    result = []
    for i,num in enumerate(l1):
        num1 = num1+num*(10**(length1-i-1))
    for i,num in enumerate(l2):
        num2 = num2+num*(10**(length2-i-1))
    final = num1 + num2
    for i in range(len(str(final))-1,-1,-1):
        result.append(int(str(final)[i]))
