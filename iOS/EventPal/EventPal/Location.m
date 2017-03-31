//
//  Location.m
//  EventPal
//
//  Created by Yan Kononov on 29/03/2017.
//  Copyright © 2017 Yanislav Kononov. All rights reserved.
//

#import "Location.h"

@implementation Location
-(nonnull instancetype) initWithLatitude:(CLLocationDegrees) latitude longitude:(CLLocationDegrees) longtitude
{
    Location* location = [[Location alloc] init];
    location.latitude = latitude;
    location.longtitude = longtitude;
    return location;
}
-(CLLocationCoordinate2D) coordinates
{
    return CLLocationCoordinate2DMake(self.latitude, self.longtitude);
};
@end
