# from typing import List


class Solution:
    def isIdealPermutation(self, A):
        """
        :type A: List[int]
        :rtype: bool
        """
        result = True
        if len(A) <= 2:
            return 'true'
        for i in range(0, len(A) - 1):
            for j in range(i + 2, len(A)):
                if A[i] > A[j]:
                    result = False
        return 'true' if result else 'false'


if __name__ == '__main__':
    test = Solution()
    print(test.isIdealPermutation([1, 2, 0]))
