package com.singleton.model.arguments;

/**
 * <p>
 * A person that has an API that takes in an argument.
 * </p>
 *
 * @author Dustin Singleton
 */
@SuppressWarnings({ "javadoc" })
public interface Person
{
    String getName();

    String getRelativeName(RelativeType relativeType);
    
    public static enum RelativeType
    {
        SPOUSE,
        MOTHER;
    }
}
