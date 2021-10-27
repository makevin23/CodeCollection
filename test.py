class Solution:
    def exist(self, board, word: str) -> bool:
        first = word[0]
        move = set([(1,0),(-1,0),(0,1),(0,-1)])
        
        def search(i,pos,visited):
            # print('pos: '+str(pos))
            if i==len(word):
                return True
            for m in move:
                cur_pos = (pos[0]+m[0], pos[1]+m[1])
                # print('cur_pos: '+str(cur_pos))
                if cur_pos[0]>=0 and cur_pos[0]<len(board) and cur_pos[1]>=0 and cur_pos[1] < len(board[0]):
                    if board[cur_pos[0]][cur_pos[1]]==word[i] and cur_pos not in visited:
                        visited.append(cur_pos)
                        res = search(i+1, cur_pos, visited)
                        if res==True:
                            return True
                        visited.pop()
                cur_pos = pos
            return False
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j]==word[0]:
                    # print('start with '+str((i,j)))
                    if search(1,(i,j),[(i,j)]):
                        return True
        return False


                        
# test changes