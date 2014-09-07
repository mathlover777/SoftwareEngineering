format 76

activitycanvas 128002 activity_ref 128898 // paying salary to workers
  show_infonote default drawing_language default show_stereotype_properties default
  xyzwh 29 21 2000 783 519
end
activitynodecanvas 128130 activitynode_ref 131970 // initial_node
  xyz 410 124 2005
end
activityactioncanvas 128258 activityaction_ref 133250 // activity action clerk gives attendence to workers
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 370 166 2005 100 60
end
activityactioncanvas 128386 activityaction_ref 133378 // activity action checks attendence lists
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 221 170 2005 100 60
end
activityactioncanvas 128514 activityaction_ref 133506 // activity action generates salary list
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 220 267 2005 100 60
end
activityactioncanvas 128642 activityaction_ref 133634 // activity action money retrieved from salary account
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 55 268 2005 100 60
end
activityactioncanvas 128770 activityaction_ref 133762 // activity action cheque is issued
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 516 452 2005 100 60
end
activityactioncanvas 128898 activityaction_ref 133890 // activity action salary is paid
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 683 261 2005 100 60
end
activitynodecanvas 130946 activitynode_ref 132098 // activity_final
  xyz 733 427 2005
end
activitypartitioncanvas 131330 activitypartition_ref 136322 // Hall
  xyzwh 37 77 2010 144 449
end
activitypartitioncanvas 131458 activitypartition_ref 136450 // Warden
  xyzwh 180 77 2011 176 451
end
activitypartitioncanvas 131586 activitypartition_ref 136578 // Clerk
  xyzwh 355 77 2011 142 451
end
activitypartitioncanvas 131714 activitypartition_ref 136706 // Printer
  xyzwh 496 77 2005 153 452
end
activitypartitioncanvas 131842 activitypartition_ref 136834 // Worker
  xyzwh 647 77 2005 144 452
end
flowcanvas 129026 flow_ref 138626 // <flow>
  
  from ref 128130 z 2006 to ref 128258
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 129154 flow_ref 138754 // <flow>
  
  from ref 128258 z 2006 to ref 128386
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 129666 flow_ref 138882 // <flow>
  
  from ref 128386 z 2006 to ref 128514
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 129794 flow_ref 139010 // <flow>
  
  from ref 128514 z 2006 to ref 128642
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 129922 flow_ref 139138 // <flow>
  decenter_end 330
  
  from ref 128642 z 2006 to point 101 469
  line 131202 z 2006 to ref 128770
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 130690 flow_ref 139394 // <flow>
  decenter_begin 439
  
  from ref 128770 z 2006 to point 557 287
  line 130818 z 2006 to ref 128898
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 131074 flow_ref 139522 // <flow>
  decenter_begin 610
  
  from ref 128898 z 2006 to ref 130946
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
end
