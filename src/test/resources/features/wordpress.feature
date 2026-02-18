Feature: WordPress Website Flow

Scenario: Validate WordPress Website Flow
  Given User launches WordPress website
  Then Verify page title
  When User clicks Get WordPress option
  Then Verify text "Get WordPress"
  When User opens Photo Directory
  Then Search image and verify result