data Triple a b c = Triple a b c deriving (Eq,Show)

tripleFst (Triple a b c) = a
tripleSnd (Triple a b c) = b
tripleThr (Triple a b c) = c

data Quadruple a b = Quadruple a a b b deriving (Eq, Show)

firstTwo (Quadruple a b c d) = (a, b)
secondTwo (Quadruple a b c d) = (c, d)

data Tuple a b c d = TupleOne a | TupleTwo a b | TupleThree a b c | TupleFour a b c d deriving (Eq, Show)

tuple1 (TupleOne a) = Just a 
tuple1 (TupleTwo a b) = Just a
tuple1 (TupleThree a b c) = Just a
tuple1 (TupleFour a b c d) = Just a

tuple2 (TupleOne a) = Nothing 
tuple2 (TupleTwo a b) = Just b
tuple2 (TupleThree a b c) = Just b
tuple2 (TupleFour a b c d) = Just b

tuple3 (TupleThree a b c) = Just c
tuple3 (TupleFour a b c d) = Just c
tuple3 _ = Nothing
 
tuple4 (TupleFour a b c d) = Just d
tuple4 _ = Nothing

data List a = Nil | Cons a (List a) deriving (Eq,Show)

listLength Nil = 0
listLength (Cons x xs) = 1 + listLength xs

listHead Nil = error "Empty list"
listHead (Cons x xs) = x

listTail Nil = error "Empty list"
listTail (Cons x xs) = xs

listFoldr f v Nil = v
listFoldr f v (Cons x xs) = f x (listFoldr f v xs)


listFoldl f v Nil = v
listFoldl f v (Cons x xs) = listFoldl f (f v x) xs

data BinaryTree a = NIL | Node a (BinaryTree a) (BinaryTree a) deriving (Eq,Show)

sizeBST NIL = 0
sizeBST (Node a left right) = 1 + sizeBST left + sizeBST right

isBST NIL = True
isBST (Node a NIL NIL) = True
isBST (Node a left right) = (isBST left) && (isBST right) && and(map (< a) leftList) && and(map (> a) rightList)
    where
      leftList = order left
      rightList = order right

insert NIL (Node a NIL NIL) = Node a NIL NIL
insert (Node a NIL NIL) (Node b NIL NIL) | a > b = Node a (Node b NIL NIL) NIL
                                         | otherwise = Node a NIL (Node b NIL NIL)
                          
insert (Node a left right) (Node b NIL NIL) | a > b = Node a (insert left (Node b NIL NIL)) right
                                            | otherwise = Node a left (insert right (Node b NIL NIL))

search NIL _ = NIL
search (Node a left right) b | a > b = search left b
                             | a < b = search right b
                             | otherwise = (Node a left right)

maximum_bst NIL = 0
maximum_bst (Node a NIL NIL) = a
maximum_bst (Node a left right) = max(a, maximum_bst right)

minimum_bst NIL = NIL
minimum_bst (Node a NIL NIL) = a
minimum_bst (Node a left right) = minimum_bst left

predecessor = undefined

successor = undefined

remove = undefined

preOrder NIL = []
preOrder (Node a left right) = [a] ++ preOrder left ++ preOrder right

order NIL = []
order (Node a left right) = order left ++ [a] ++ order right

postOrder NIL = []
postOrder (Node a left right) = postOrder left ++ postOrder right ++ [a]
