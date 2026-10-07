	.data 
	.org 0x100
vector: 	.byte 0,1,4,5,0,2,6,0

	.code
	.org 0x200
	daddi r6, r0, 8
	daddi r4, r0, 0
	daddi r10, r0, 0
	
loop: 	lb r1, vector(r4)
	daddi r4,r4, 1
	slti r9,r1, 1
if:	beqz r9,else
	daddi r10,r10, 1
else:	slt r2,r4,r6
	bnez r2,loop
fin: 	halt
