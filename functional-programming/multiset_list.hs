module MultisetList ()
 where

insert elem [] = [(elem, 1)]
insert elem bag | elem == first = [(first, second + 1)] ++ (tail bag)
                | otherwise = [(first, second)] ++ insert elem (tail bag)
    where
        first = fst(head bag)
        second = snd(head bag)

remove _ [] = []
remove elem bag | elem == first = if (second == 1) then (tail bag) else [(first, second - 1)] ++ (tail bag)
                | otherwise = [(first, second)] ++ remove elem (tail bag)
    where
        first = fst(head bag)
        second = snd(head bag)
        
search elem [] = 0
search elem bag | elem == first = second
                | otherwise = search elem (tail bag)
    where
        first = fst(head bag)
        second = snd(head bag)   
                
union bag1 [] = bag1
union bag1 bag2 | (search first bag1 == 0) = union (bag1 ++ [(first, second)]) (tail bag2)
                | otherwise = []
    
    where
        first = fst(head bag2) 
        second = snd(head bag2)
        
intersection bag1 bag2 = undefined
minus bag1 bag2 = undefined
inclusion bag1 bag2 = undefined

sum bag1 [] = bag1
sum bag1 bag2 = | (search first bag1 == 0) = sum (bag1 ++ [(first, second)]) (tail bag2)
                | otherwise = 

    where
        first = fst(head bag2) 
        second = snd(head bag2)

size [] = 0
size bag = snd(head bag) + size (tail bag)
