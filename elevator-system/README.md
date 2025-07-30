
FR - 
1) A building has N floors and M elevators
2) A user can : call an elevator from a floor, Choos a floor inside an elevator
3) The system should assign best elevarot for each request, Move elevator between floors efficeiently.
4) Handle edge cases Multiple Simultaneous requests, idle elevators, direction conflicts.

NFR
1) Efficiency : Minimize the wait Time.
2) Scalability : Handle 20+ elevators, 100+ floors
3) Fault tolerance : if one elevator is office, reassign requests
4) Extensibility : Support express elevators, VIP mode later.




Key patterns used:
Strategy -> Shceduler( nearest, Look, SCAN)
State pattern -> Elevator state machine(IDLE, MOVING_UP etc)
Command -> Request queue for each elevator
Observer -> Notify display, logs