format 76

activitycanvas 128002 activity_ref 128258 // requesting and granting fund
  show_infonote default drawing_language default show_stereotype_properties default
  xyzwh 44 35 2000 775 633
end
activitynodecanvas 128130 activitynode_ref 129282 // initial_node
  xyz 87 180 2005
end
activityactioncanvas 128258 activityaction_ref 129922 // activity action enter salary for clerk
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 179 159 2005 100 60
end
activityactioncanvas 128514 activityaction_ref 130050 // activity action enter salary for daily workers
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 178 248 2005 100 60
end
activityactioncanvas 129410 activityaction_ref 130178 // activity action enter est. number of gardeners and attendent for the year
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 156 359 2005 146 90
end
activityactioncanvas 129538 activityaction_ref 130306 // activity action enter est. misc charges
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 178 510 2005 100 60
end
activityactioncanvas 129666 activityaction_ref 130434 // activity action hmc views the grants
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 439 156 2005 100 60
end
activitynodecanvas 129922 activitynode_ref 129538 // activity_final
  xyz 689 567 2005
end
activityactioncanvas 130050 activityaction_ref 130562 // activity action add money to salaryAccount
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 441 423 2010 100 60
end
activityactioncanvas 130178 activityaction_ref 130690 // activity action add money to Misc Account
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 440 550 2005 100 60
end
activitynodecanvas 131202 activitynode_ref 129666 // decision
  xyz 477 310 2005
end
activitypartitioncanvas 132354 activitypartition_ref 135298 // warden
  xyzwh 78 103 2011 305 535
end
activitypartitioncanvas 132482 activitypartition_ref 135426 // HMC
  xyzwh 382 104 2005 388 534
end
flowcanvas 130306 flow_ref 131330 // <flow>
  
  from ref 128130 z 2006 to ref 128258
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 130434 flow_ref 131458 // <flow>
  
  from ref 128258 z 2006 to ref 128514
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 130562 flow_ref 131586 // <flow>
  
  from ref 128514 z 2006 to ref 129410
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 130690 flow_ref 131714 // <flow>
  
  from ref 129410 z 2006 to ref 129538
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 130818 flow_ref 131842 // <flow>
  
  from ref 129538 z 2006 to point 330 537
  line 132098 z 2006 to point 330 183
  line 132226 z 2006 to ref 129666
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 131330 flow_ref 132226 // grant is proper
  
  from ref 129666 z 2006 label "grant is proper" xyz 493 250 2006 to ref 131202
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 131458 flow_ref 132354 // true
  
  from ref 131202 z 2011 label "true" xyz 503 380 2011 to ref 130050
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 131586 flow_ref 132482 // false
  
  from ref 131202 z 2006 label "false" xyz 589 338 2006 to point 699 326
  line 131970 z 2006 to ref 129922
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 131714 flow_ref 132610 // <flow>
  
  from ref 130050 z 2011 to ref 130178
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 131842 flow_ref 132738 // <flow>
  
  from ref 130178 z 2006 to ref 129922
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
end
