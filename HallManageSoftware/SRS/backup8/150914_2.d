format 76

pseudostatecanvas 128002 pseudostate_ref 128514 // final
   xyz 368 415.5 2000
end
pseudostatecanvas 128130 pseudostate_ref 128386 // initial
   xyz 239 68.5 2000
end
statecanvas 128258 state_ref 129922 // Student's mess charge is set
  show_activities default region_horizontally default drawing_language default show_stereotype_properties default
  xyzwh 288 325.5 2000 183 33
end
statecanvas 128386 state_ref 129794 // Students room rent is set
  show_activities default region_horizontally default drawing_language default show_stereotype_properties default
  xyzwh 601 325.5 2000 163 33
end
statecanvas 128514 state_ref 129666 // Student's room is assigned
  show_activities default region_horizontally default drawing_language default show_stereotype_properties default
  xyzwh 595 135.5 2000 173 33
end
statecanvas 128642 state_ref 129538 // Student's hall name is added
  show_activities default region_horizontally default drawing_language default show_stereotype_properties default
  xyzwh 371 136.5 2000 179 33
end
statecanvas 128770 state_ref 129410 // Student's details are set
  show_activities default region_horizontally default drawing_language default show_stereotype_properties default
  xyzwh 170 133.5 2000 155 33
end
transitioncanvas 128898 transition_ref 129794 // <transition>
  
  from ref 128642 z 2001 to ref 128514
  write_horizontally default show_definition default drawing_language default
end
transitioncanvas 129026 transition_ref 130050 // <transition>
  
  from ref 128386 z 2001 to ref 128258
  write_horizontally default show_definition default drawing_language default
end
transitioncanvas 129154 transition_ref 129666 // <transition>
  
  from ref 128770 z 2001 to ref 128642
  write_horizontally default show_definition default drawing_language default
end
transitioncanvas 129282 transition_ref 129922 // <transition>
  
  from ref 128514 z 2001 to ref 128386
  write_horizontally default show_definition default drawing_language default
end
transitioncanvas 129410 transition_ref 130178 // <transition>
  
  from ref 128258 z 2001 to ref 128002
  write_horizontally default show_definition default drawing_language default
end
transitioncanvas 129538 transition_ref 129538 // <transition>
  
  from ref 128130 z 2001 to ref 128770
  write_horizontally default show_definition default drawing_language default
end
end
